package com.github.dsaouda.fiaptelembra.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.github.dsaouda.fiaptelembra.model.*
import com.google.gson.Gson
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

    fun toJson(): String {
        return Gson().toJson(this)
    }

}

//Extension Functions
fun LocalDateTime.toDate(): Date = Timestamp.valueOf(this)

data class LembreteCreateDTO(val data: String, val hora: String, val mensagem: String, val pessoas: List<Int>) {

    fun toLembrete(cliente: Cliente?): Lembrete {
        val enviarEm = getEnviarEm()
        return Lembrete(mensagem = mensagem, pessoas = pessoas.joinToString(","), enviarEm = enviarEm.toDate(), cliente = cliente)
    }

    fun getEnviarEm() = LocalDateTime.parse("${data} ${hora}", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    fun toLembrete() = toLembrete(null)
}

data class LembreteNaoEnviadoDTO(val id: Long?, val dataHoraEnvio: String?, val mensagem: String?, val totalContatos: Int?)
data class LembreteEnviadoDTO(val dataHoraAgendamento: String?, val dataHoraEnvio: String?, val mensagem: String?, val totalContatos: Int?, val statusEnvio: Status?, val statusMensagem: String?)