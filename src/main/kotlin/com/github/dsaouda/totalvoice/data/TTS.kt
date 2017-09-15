package com.github.dsaouda.totalvoice.data

import com.google.gson.annotations.SerializedName

data class TTS (
        @SerializedName("numero_destino")
        val numeroDestino: String,

        @SerializedName("mensagem")
        val mensagem: String,

        @SerializedName("bina")
        val bina: String,

        @SerializedName("velocidade")
        val velocidade: Int = 0,

        @SerializedName("resposta_usuario")
        val respostaUsuario: Boolean = false,

        @SerializedName("tipo_voz")
        val tipoVoz: String = "br-Vitoria"
)
