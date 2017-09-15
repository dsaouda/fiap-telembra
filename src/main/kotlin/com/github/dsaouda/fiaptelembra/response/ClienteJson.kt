package com.github.dsaouda.fiaptelembra.response

import com.github.dsaouda.fiaptelembra.model.Cliente

data class ClienteJson(
    val id: Long? = null,
    val nome: String? = null,
    val ativo: Boolean? = null
) {

    fun toCliente(): Cliente {
        return Cliente(id, nome!!, ativo!!)
    }

}