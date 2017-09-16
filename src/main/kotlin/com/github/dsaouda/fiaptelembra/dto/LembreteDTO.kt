package com.github.dsaouda.fiaptelembra.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.github.dsaouda.fiaptelembra.model.*
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
    val pessoa: Long? = null,
    val cliente: Long? = null
) {

    fun toLembrete(): Lembrete {
        return Lembrete(id, mensagem, enviarEm, enviadaEm, status, mensagemStatus, Pessoa(id=pessoa), Cliente(id=cliente))
    }

}