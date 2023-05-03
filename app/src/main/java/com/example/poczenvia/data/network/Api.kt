package com.example.poczenvia.data.network

import com.example.poczenvia.data.network.response.OriginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/webphone")
    suspend fun callFast(
        @Query("tipo") tipo: String,
        @Query("id_ramal") idRamal: Int,
        @Query("ramal") ramal: String,
        @Query("ligar_para") ligarPara: String,
        @Query("fechar_fim") fecharFim: Boolean,
    ): Response<OriginResponse>
}