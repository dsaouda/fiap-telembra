package com.github.dsaouda.totalvoice

import com.github.dsaouda.totalvoice.interceptor.AccessTokenInterceptor
import com.github.dsaouda.totalvoice.service.TTSService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TotalVoice {

    private val retrofit: Retrofit

    constructor(interceptor: AccessTokenInterceptor) {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        retrofit = Retrofit.Builder()
                .baseUrl("http://api.totalvoice.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
    }

    fun tts(): TTSService {
        return retrofit.create<TTSService>(TTSService::class.java)
    }

}