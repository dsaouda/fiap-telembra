package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.dto.LoginDTO
import com.github.dsaouda.fiaptelembra.dto.PessoaDTO
import com.github.dsaouda.fiaptelembra.repository.LoginRepository
import com.github.dsaouda.fiaptelembra.repository.PessoaRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/login")
class LoginController {

    @Autowired
    lateinit var repository: LoginRepository

    @PostMapping
    fun create(@RequestBody loginDTO: LoginDTO): ResponseEntity<Any> {

        val login = repository.findFirstByEmailAndSenha(loginDTO.email!!, loginDTO.senha!!)
        if (login == null) {
            return ResponseEntity<Any>("email e/ou senha não são válidos", HttpStatus.FORBIDDEN)
        }

        return ResponseEntity<Any>(login.toDTO(), HttpStatus.CREATED)
    }
}