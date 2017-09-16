package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.dto.PessoaDTO
import com.github.dsaouda.fiaptelembra.repository.PessoaRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/pessoa")
class PessoaController {

    @Autowired
    lateinit var repository: PessoaRepository

    @PostMapping
    fun create(@RequestBody pessoaDTO: PessoaDTO): ResponseEntity<Any> {

        val pessoa = pessoaDTO.toPessoa()
        repository.save(pessoa)

        return ResponseEntity<Any>(pessoa.toDTO(), HttpStatus.CREATED)
    }
}