package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Lembrete
import com.github.dsaouda.fiaptelembra.model.Login
import com.github.dsaouda.fiaptelembra.model.Pessoa
import com.github.dsaouda.fiaptelembra.repository.ClienteRepository
import com.github.dsaouda.fiaptelembra.repository.LembreteRepository
import com.github.dsaouda.fiaptelembra.repository.LoginRepository
import com.github.dsaouda.fiaptelembra.repository.PessoaRepository
import com.github.dsaouda.totalvoice.data.TTS
import com.github.dsaouda.totalvoice.service.TTSService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ClienteControllerOld {

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
        val cliente = Cliente(nome = "teste", ativo = false)
        val login = Login(nome = "Di", email = "diegosaouda@gmail.com", senha = "123", cliente = cliente)
        val pessoa = Pessoa(nome = "Diego Saouda", telefone = "(11) 995478336", cliente = cliente)
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