package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.disque.Disque
import com.github.dsaouda.fiaptelembra.repository.ClienteRepository
import com.github.dsaouda.fiaptelembra.dto.ClienteDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/cliente")
class ClienteController {

    @Autowired
    lateinit var repository: ClienteRepository

    @Autowired
    lateinit var disque: Disque

    @PostMapping
    fun create(@RequestBody clienteDTO: ClienteDTO): ResponseEntity<Any> {
        val cliente = clienteDTO.toCliente()
        repository.save(cliente);
        return ResponseEntity<Any>(cliente.toJson(), HttpStatus.CREATED)
    }

    @GetMapping
    fun get() {
        println("DISQUE TESTE")
        disque.addJob("queue", "via spring ${LocalDateTime.now()}")
    }
}