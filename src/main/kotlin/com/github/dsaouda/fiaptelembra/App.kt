package com.github.dsaouda.fiaptelembra

import com.github.dsaouda.totalvoice.TotalVoice
import com.github.dsaouda.totalvoice.interceptor.AccessTokenInterceptor
import com.github.dsaouda.totalvoice.service.TTSService
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature


@SpringBootApplication
class App {

    @Bean
    @Value("\${totalvoice.token}")
    fun initTotalVoiceTTTS(token: String): TTSService {
        val interceptor = AccessTokenInterceptor(token)
        return TotalVoice(interceptor).tts()
    }

    @Bean
    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val mapper = ObjectMapper()
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        return MappingJackson2HttpMessageConverter(mapper)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
