package com.github.dsaouda.fiaplembrou

import com.github.dsaouda.totalvoice.TotalVoice
import com.github.dsaouda.totalvoice.interceptor.AccessTokenInterceptor
import com.github.dsaouda.totalvoice.service.TTSService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class App {

    @Bean
    @Value("\${totalvoice.token}")
    fun initTotalVoiceTTTS(token: String): TTSService {
        val interceptor = AccessTokenInterceptor(token)
        return TotalVoice(interceptor).tts()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
