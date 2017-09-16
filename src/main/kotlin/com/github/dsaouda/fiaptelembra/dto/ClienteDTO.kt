package com.github.dsaouda.fiaptelembra.dto

import com.github.dsaouda.fiaptelembra.model.Cliente

data class ClienteDTO(
    val id: Long? = null,
    val nome: String? = null,
    val ativo: Boolean? = null
) {

    fun toCliente(): Cliente {
        return Cliente(id, nome!!, ativo!!)
    }

}