package com.github.dsaouda.fiaptelembra.model

import com.github.dsaouda.fiaptelembra.response.ClienteJson
import javax.persistence.*

@Entity
@Table(name="cliente")
data class Cliente(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val ativo: Boolean = true
) {

    fun toJson(): ClienteJson {
        return ClienteJson(id, nome, ativo)
    }

}