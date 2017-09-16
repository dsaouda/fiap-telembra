package com.github.dsaouda.fiaptelembra.model

import com.github.dsaouda.fiaptelembra.dto.ClienteDTO
import javax.persistence.*

@Entity
@Table(name="cliente")
data class Cliente(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String?=null,
    val ativo: Boolean = true
) {

    fun toJson(): ClienteDTO {
        return ClienteDTO(id, nome, ativo)
    }

}