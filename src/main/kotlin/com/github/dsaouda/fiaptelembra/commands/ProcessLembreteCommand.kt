package com.github.dsaouda.fiaptelembra.commands

import com.github.dsaouda.disque.Disque
import com.github.dsaouda.fiaptelembra.dto.LembreteDTO
import com.github.dsaouda.fiaptelembra.model.Status
import com.github.dsaouda.fiaptelembra.repository.LembreteRepository
import com.github.dsaouda.fiaptelembra.repository.PessoaRepository
import com.github.dsaouda.totalvoice.data.TTS
import com.github.dsaouda.totalvoice.service.TTSService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import retrofit2.Response
import java.util.*

@ShellComponent
class ProcessLembreteCommand {

    @Autowired
    private lateinit var disque: Disque

    @Autowired
    private lateinit var repoPessoa: PessoaRepository

    @Autowired
    private lateinit var repoLembrete: LembreteRepository

    @Value("\${totalvoice.bina}")
    private lateinit var bina: String

    @Autowired
    private lateinit var totalVoice: TTSService

    @ShellMethod(key = arrayOf("pl"), value="Processar os lembretes")
    fun execute(): String {
        println("inicio servidor de processamento de lembretes")

        while(true) {
            val job = disque.deamonGetJob("queue")

            println("processando job#${job.id} => ${job.body}")

            val json = Gson().fromJson(job.body, LembreteDTO::class.java)
            val lembrete = repoLembrete.findOne(json.id)

            if (lembrete == null) {
                disque.ackjob(job.id)
                continue
            }

            val ids = lembrete.pessoas?.split(",")?.map { it.toLong() }

            //pegando apenas a última mensagem para facilitar :(  faltou tempo
            var response: Response<Any>? = null

            val pessoas = repoPessoa.findAllById(ids!!)
            pessoas.forEach{
                val tts = TTS(it.telefone!!, job.body, bina)

                println("request total voice => ${tts}")
                response = totalVoice.send(tts).execute()
                println("response => ${response}")
            }

            val status = if (response?.code() === 200) Status.ENVIADO_SUCESSO else Status.ENVIADO_ERRO

            repoLembrete.save(lembrete.copy(enviadaEm = Date(), status=status, mensagemStatus = response?.message()))
            disque.ackjob(job.id)
        }

        return ""
    }

}