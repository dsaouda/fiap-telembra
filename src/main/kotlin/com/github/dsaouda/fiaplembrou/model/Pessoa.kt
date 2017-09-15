package com.github.dsaouda.fiaplembrou.model

import org.hibernate.validator.constraints.Email
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
        val nome: String,

        @NotNull
        val telefone: String,

        @ManyToOne(fetch= FetchType.LAZY, optional=false)
        @JoinColumn(name = "id_cliente")
        val cliente: Cliente
)