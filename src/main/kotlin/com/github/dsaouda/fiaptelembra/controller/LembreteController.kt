package com.github.dsaouda.fiaptelembra.controller

import com.github.dsaouda.disque.Disque
import com.github.dsaouda.fiaptelembra.component.Session
import com.github.dsaouda.fiaptelembra.dto.LembreteCreateDTO
import com.github.dsaouda.fiaptelembra.dto.LembreteEnviadoDTO
import com.github.dsaouda.fiaptelembra.dto.LembreteNaoEnviadoDTO
import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.repository.LembreteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/lembretes")
class LembreteController {

    private val repository: LembreteRepository
    private val disque: Disque
    private val sdf = SimpleDateFormat("dd/MM/YYYY HH:mm:ss")
    private val session: Session

    constructor(repository: LembreteRepository, disque: Disque, session: Session) {
        this.repository = repository
        this.disque = disque
        this.session = session
    }

    @PostMapping
    fun create(@RequestBody lembreteDTO: LembreteCreateDTO): ResponseEntity<Any> {
        val lembrete = lembreteDTO.toLembrete(session.cliente())
        repository.save(lembrete)

        disque.addScheduleJob("queue", lembrete.toDTO().toJson(), lembreteDTO.getEnviarEm())
        return ResponseEntity<Any>(lembrete, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        repository.delete(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @GetMapping
    fun all(): Any {
        return repository.findByCliente(session.cliente())
    }

    @GetMapping("/nao-enviado")
    fun allNaoEnviado(): Any {
        val lembretes = repository.findNaoEnviado(session.cliente())

        return lembretes.map{
            LembreteNaoEnviadoDTO(
                    it.id!!,
                    sdf.format(it.enviarEm),
                    it.mensagem!!,
                    it.pessoas?.split(",")?.size!!
            )
        }
    }

    @GetMapping("/enviado")
    fun allEnviado(): Any {

        val lembretes = repository.findEnviado(session.cliente())

        return lembretes.map{
            LembreteEnviadoDTO(
                    sdf.format(it.enviarEm),
                    sdf.format(it.enviadaEm),
                    it.mensagem,
                    it.pessoas?.split(",")?.size,
                    it.status,
                    it.mensagemStatus
            )
        }
    }
}