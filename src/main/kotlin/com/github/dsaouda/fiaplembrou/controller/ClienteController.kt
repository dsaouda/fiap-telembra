package com.github.dsaouda.fiaplembrou.controller

import com.github.dsaouda.fiaplembrou.model.Cliente
import com.github.dsaouda.fiaplembrou.model.Lembrete
import com.github.dsaouda.fiaplembrou.model.Login
import com.github.dsaouda.fiaplembrou.model.Pessoa
import com.github.dsaouda.fiaplembrou.repository.ClienteRepository
import com.github.dsaouda.fiaplembrou.repository.LembreteRepository
import com.github.dsaouda.fiaplembrou.repository.LoginRepository
import com.github.dsaouda.fiaplembrou.repository.PessoaRepository
import com.github.dsaouda.totalvoice.TotalVoice
import com.github.dsaouda.totalvoice.data.TTS
import com.github.dsaouda.totalvoice.service.TTSService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ClienteController {

    @Autowired
    lateinit var repository: ClienteRepository

    @Autowired
    lateinit var loginRepository: LoginRepository

    @Autowired
    lateinit var pessoaRepository: PessoaRepository

    @Autowired
    lateinit var lembreteRepository: LembreteRepository

    @Autowired
    lateinit var totalvoice: TTSService

    @GetMapping("/")
    fun teste() {
        val cliente = Cliente(nome="teste", ativo=false)
        val login = Login(nome="Di", email="diegosaouda@gmail.com", senha="123", cliente=cliente)
        val pessoa = Pessoa(nome="Diego Saouda", telefone="(11) 995478336", cliente=cliente)
        val lembrete = Lembrete(mensagem = "Olá, isso é um teste", enviarEm = Date(), cliente = cliente, pessoa = pessoa)

        repository.save(cliente)
        loginRepository.save(login)
        pessoaRepository.save(pessoa)
        lembreteRepository.save(lembrete)

        println(cliente)
        println(login)
        println(pessoa)
        println(lembrete)

        val tts = TTS("11995478336", "Olá, isso é um teste em Kotlin", "11995478336")
        println(totalvoice.send(tts).execute())
    }
}