package com.github.dsaouda.fiaptelembra

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.github.dsaouda.disque.Disque
import com.github.dsaouda.totalvoice.TotalVoice
import com.github.dsaouda.totalvoice.interceptor.AccessTokenInterceptor
import com.github.dsaouda.totalvoice.service.TTSService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    @Value("\${totalvoice.token}")
    fun getTotalVoiceTTTS(token: String): TTSService {
        val interceptor = AccessTokenInterceptor(token)
        return TotalVoice(interceptor).tts()
    }


    @Bean
    @Value("\${disque}")
    fun getDisque(host: String) = Disque(host)


    @Bean
    fun getObjectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.findAndRegisterModules()
        mapper.registerModule(KotlinModule())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        return mapper
    }
}
