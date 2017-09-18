package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.repository.ClienteRepository
import com.github.dsaouda.fiaptelembra.dto.ClienteDTO
import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Login
import com.github.dsaouda.fiaptelembra.repository.LoginRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.DigestUtils

@RestController
@RequestMapping("/criar-conta")
class CriarContaController (private val repoCliente: ClienteRepository, private val repoLogin: LoginRepository) {

    @PostMapping
    fun create(@RequestBody criarConta: CriarContaPostCreateDTO): ResponseEntity<Any> {
        val cliente = repoCliente.save(criarConta.cliente)

        val key = "${criarConta.login.email}/${criarConta.login.senha}"
        val token = DigestUtils.md5DigestAsHex(key.toByteArray())
        val login = criarConta.login.copy(cliente = cliente, token = token)
        repoLogin.save(login)

        return ResponseEntity<Any>(criarConta, HttpStatus.CREATED)
    }
}

data class CriarContaPostCreateDTO(val cliente: Cliente, val login: Login)