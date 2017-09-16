package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.dto.LembreteDTO
import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.repository.LembreteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lembretes")
class LembreteController constructor (private val repository: LembreteRepository) {

    @PostMapping
    fun create(@RequestBody lembreteDTO: LembreteDTO): ResponseEntity<Any> {
        val lembrete = lembreteDTO.toLembrete()
        repository.save(lembrete)
        return ResponseEntity<Any>(lembrete.toDTO(), HttpStatus.CREATED)
    }

    @GetMapping
    fun all(): Any {
        return repository.findByCliente(Cliente(1))
    }

    @GetMapping("/nao-enviado")
    fun allNaoEnviado(): Any {
        return repository.findNaoEnviado(Cliente(1))
    }

    @GetMapping("/enviado")
    fun allEnviado(): Any {
        return repository.findEnviado(Cliente(1))
    }
}