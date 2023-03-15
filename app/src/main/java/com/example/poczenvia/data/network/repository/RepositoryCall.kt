package com.example.poczenvia.data.network.repository

import com.example.poczenvia.data.network.RetrofitInstance
import com.example.poczenvia.data.network.response.OriginRequest
import com.example.poczenvia.data.network.response.OriginResponse
import retrofit2.Response

class RepositoryCall {

    suspend fun callFast(originCall: OriginRequest): Response<OriginResponse> {
        return RetrofitInstance.api.callFast(originCall)
    }

}