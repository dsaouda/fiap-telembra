package com.github.dsaouda.totalvoice

import com.github.dsaouda.totalvoice.data.TTS
import com.github.dsaouda.totalvoice.interceptor.AccessTokenInterceptor
import com.github.dsaouda.totalvoice.service.TTSService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

fun main(args: Array<String>) {

    //val service = TotalVoice(AccessTokenInterceptor("1")).tts()

    val tts = TTS("11995478336", "Olá, isso é um teste em Kotlin", "11995478336")
    //val execute = service.send(tts).execute()
    //println(execute)

}