package com.github.dsaouda.fiaptelembra.dto

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Pessoa

data class PessoaDTO(
    val id: Long? = null,
    val nome: String? = null,
    val telefone: String? = null,
    val cliente: Long? = null
) {

    fun toPessoa(): Pessoa {
        return Pessoa(id, nome!!, telefone!!, Cliente(id=cliente))
    }

}