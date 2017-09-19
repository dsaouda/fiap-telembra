package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.component.Session
import com.github.dsaouda.fiaptelembra.dto.PessoaDTO
import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.repository.PessoaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoa")
class PessoaController (private val repository: PessoaRepository, private val session: Session) {

    @PostMapping
    fun create(@RequestBody pessoaDTO: PessoaDTO): ResponseEntity<Any> {
        val pessoa = pessoaDTO.toPessoa(session.cliente())
        repository.save(pessoa)

        return ResponseEntity<Any>(pessoa.toDTO(), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val pessoa = repository.findOne(id).toDTO()

        return ResponseEntity<Any>(pessoa, HttpStatus.OK)
    }

    @GetMapping
    fun all(): ResponseEntity<Any> {
        val pessoas = repository.findAll(session.cliente())
        return ResponseEntity<Any>(pessoas, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        repository.delete(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}