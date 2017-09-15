package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.repository.ClienteRepository
import com.github.dsaouda.fiaptelembra.response.ClienteJson
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/cliente")
class ClienteController {

    @Autowired
    lateinit var repository: ClienteRepository

    @PostMapping
    fun create(@RequestBody clienteJson: ClienteJson): ResponseEntity<Any> {
        val cliente = clienteJson.toCliente()
        repository.save(cliente);
        return ResponseEntity<Any>(cliente.toJson(), HttpStatus.CREATED)
    }
}