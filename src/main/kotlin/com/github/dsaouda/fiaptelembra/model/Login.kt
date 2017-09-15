package com.github.dsaouda.fiaptelembra.model

import org.hibernate.validator.constraints.Email
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name="login")
data class Login(
        @NotNull
        @Size(min=4, max=80, message="Nome precisa ter mais de {min} caracteres e menos que {max}")
        val nome: String,

        @NotNull @Email
        val email: String,

        val senha: String,

        @ManyToOne(fetch=FetchType.LAZY, optional=false)
        @JoinColumn(name = "id_cliente")
        val cliente: Cliente,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)