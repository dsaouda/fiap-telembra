package com.github.dsaouda.fiaptelembra.model

import com.github.dsaouda.fiaptelembra.dto.PessoaDTO
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name="pessoa")
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @Size(min=4, max=80, message="Nome precisa ter mais de {min} caracteres e menos que {max}")
    val nome: String? = null,

    @NotNull
    val telefone: String? = null,

    @ManyToOne(fetch= FetchType.LAZY, optional=false)
    @JoinColumn(name = "id_cliente")
    val cliente: Cliente? = null
) {

    fun toDTO(): PessoaDTO {
        return PessoaDTO(id, nome, telefone, cliente?.id);
    }
}