package com.github.dsaouda.fiaptelembra.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.github.dsaouda.fiaptelembra.model.*
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class LembreteDTO(
    val id: Long? = null,
    val mensagem: String? = null,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    val enviarEm: Date? = null,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    val enviadaEm: Date? = null,

    val status: Status? = null,
    val mensagemStatus: String? = null,
    val pessoas: String? = null,
    val cliente: Long? = null
) {

    fun toLembrete(): Lembrete {
        return Lembrete(id, mensagem, enviarEm, enviadaEm, status, mensagemStatus, pessoas, Cliente(id=cliente))
    }

}

//Extension Functions
fun LocalDateTime.toDate(): Date = Timestamp.valueOf(this)

data class LembreteCreateDTO(val data: String, val hora: String, val mensagem: String, val pessoas: List<Int>) {

    fun toLembrete(cliente: Cliente?): Lembrete {
        val enviarEm = LocalDateTime.parse("${data} ${hora}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        return Lembrete(mensagem = mensagem, pessoas = pessoas.joinToString(","), enviarEm = enviarEm.toDate(), cliente = cliente)
    }

    fun toLembrete() = toLembrete(null)
}