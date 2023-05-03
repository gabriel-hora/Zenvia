package com.example.poczenvia.data.network.repository

import com.example.poczenvia.data.network.RetrofitInstance
import com.example.poczenvia.data.network.response.OriginResponse
import retrofit2.Response

class RepositoryCall {
    suspend fun callFast(
        tipo: String,
        idRamal: Int,
        ramal: String,
        ligarPara: String,
        fecharFim: Boolean
    ): Response<OriginResponse> {
        return RetrofitInstance.api.callFast(tipo, idRamal, ramal, ligarPara, fecharFim)
    }
}