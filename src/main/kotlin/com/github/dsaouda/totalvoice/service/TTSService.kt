package com.github.dsaouda.totalvoice.service

import com.github.dsaouda.totalvoice.data.TTS
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TTSService {

    @POST("/tts")
    fun send(@Body tts: TTS): Call<Any>
}