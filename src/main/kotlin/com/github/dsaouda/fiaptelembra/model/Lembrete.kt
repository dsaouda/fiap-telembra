package com.github.dsaouda.fiaptelembra.model

import com.github.dsaouda.fiaptelembra.dto.LembreteDTO
import java.util.*
import javax.persistence.*

@Entity
@Table(name="lembrete")
data class Lembrete(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val mensagem: String? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_enviar_lembrete")
    val enviarEm: Date? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_lembrete_enviado")
    val enviadaEm: Date? = null,

    @Enumerated(EnumType.STRING)
    val status: Status? = null,

    @Column(name = "status_mensagem")
    val mensagemStatus: String? = null,

    //@ManyToOne(fetch= FetchType.LAZY)
    //@JoinColumn(name = "id_pessoa")
    @Column(name = "id_pessoas")
    val pessoas: String? = null,

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    val cliente: Cliente? = null
) {

    fun toDTO(): LembreteDTO {
        return LembreteDTO(id, mensagem, enviarEm,  enviadaEm, status, mensagemStatus, pessoas, cliente?.id)
    }
}

