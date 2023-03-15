package com.example.poczenvia.data.network

import com.example.poczenvia.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Access-Token", BuildConfig.TOKEN)
            .build()
        return chain.proceed(request)
    }
}