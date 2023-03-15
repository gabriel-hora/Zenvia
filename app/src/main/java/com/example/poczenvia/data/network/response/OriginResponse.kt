package com.example.poczenvia.data.network.response

data class OriginResponse(
    val status: Int,
    val sucesso: Boolean,
    val motivo: Int,
    val mensagem: String,
    val dados: DadosResponse
)
