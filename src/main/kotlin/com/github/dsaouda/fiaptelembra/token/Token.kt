package com.github.dsaouda.fiaptelembra.token

import com.github.dsaouda.fiaptelembra.model.Cliente

object Token {
    private val memoria = mutableMapOf<String, Cliente>()

    fun add(token: String, cliente: Cliente) {
        memoria[token] = cliente
    }

    fun remove(token: String) {
        memoria.remove(token)
    }

    fun hasNot(token: String) = !has(token)
    fun has(token: String) = memoria.containsKey(token)
    fun get(token: String) = memoria[token]
}