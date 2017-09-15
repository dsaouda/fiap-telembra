package com.github.dsaouda.fiaplembrou.model

import javax.persistence.*

@Entity
@Table(name="cliente")
data class Cliente(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String,
        val ativo: Boolean = true
)