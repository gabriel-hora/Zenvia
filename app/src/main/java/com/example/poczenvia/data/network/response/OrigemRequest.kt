package com.example.poczenvia.data.network.response

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class OriginRequest(
    @SerializedName("numero_origem")
    var numeroOrigem: String,

    @SerializedName("numero_destino")
    var numeroDestino: String,

    @SerializedName("data_criacao")
    var dataCriacao: LocalDateTime?,

    @SerializedName("gravar_audio")
    var gravarAudio: Boolean?,

    @SerializedName("bina_origem")
    var binaOrigem: String?,

    @SerializedName("bina_destino")
    var binaDestino: String?,

    @SerializedName("tags")
    var tags: String?,

    @SerializedName("detecta_caixa_origem")
    var detectaCaixaOrigem: Boolean?
)
