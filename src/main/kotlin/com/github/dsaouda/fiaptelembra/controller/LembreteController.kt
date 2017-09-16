package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.fiaptelembra.dto.LembreteDTO
import com.github.dsaouda.fiaptelembra.repository.LembreteRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/lembrete")
class LembreteController {

    @Autowired
    lateinit var repository: LembreteRepository

    @PostMapping
    fun create(@RequestBody lembreteDTO: LembreteDTO): ResponseEntity<Any> {

        //val lembrete = lembreteDTO.toLembrete()
        //repository.save(lembrete)

        return ResponseEntity<Any>(lembreteDTO, HttpStatus.CREATED)
    }
}