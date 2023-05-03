package com.example.poczenvia.data.network.response

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class OriginRequest(
    @SerializedName("tipo")
    var tipo: String,

    @SerializedName("idRamal")
    var id_ramal: Int,

    @SerializedName("ramal")
    var ramal: String,

    @SerializedName("ligarPara")
    var ligar_para: String,

    @SerializedName("fecharFim")
    var fechar_fim: Boolean
)
