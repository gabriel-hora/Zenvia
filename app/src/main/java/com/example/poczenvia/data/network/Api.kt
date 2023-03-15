package com.example.poczenvia.data.network

import com.example.poczenvia.data.network.response.OriginRequest
import com.example.poczenvia.data.network.response.OriginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("/chamada")
    suspend fun callFast(
        @Body chamada: OriginRequest
    ): Response<OriginResponse>

}