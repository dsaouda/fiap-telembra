package com.github.dsaouda.fiaptelembra.dto

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.model.Login
import com.github.dsaouda.fiaptelembra.model.Pessoa

data class LoginDTO(
    val id: Long? = null,
    val nome: String? = null,
    val email: String? = null,
    val senha: String? = null,
    val cliente: Long? = null
) {

    fun toLogin(): Login {
        return Login(id, nome, email, senha, Cliente(id=cliente))
    }

}