package com.github.dsaouda.fiaplembrou.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name="lembrete")
data class Lembrete(
        val mensagem: String,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "dt_enviar_lembrete")
        val enviarEm: Date,

        @ManyToOne(fetch= FetchType.LAZY)
        @JoinColumn(name = "id_cliente")
        val cliente: Cliente,

        @ManyToOne(fetch= FetchType.LAZY)
        @JoinColumn(name = "id_pessoa")
        val pessoa: Pessoa,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "dt_lembrete_enviado")
        val enviadaEm: Date? = null,

        @Enumerated(EnumType.STRING)
        val status: Status? = null,

        @Column(name = "status_mensagem")
        val mensagemStatus: String = "",

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)