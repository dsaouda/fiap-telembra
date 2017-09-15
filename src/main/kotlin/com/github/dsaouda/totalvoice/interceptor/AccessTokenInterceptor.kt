package com.github.dsaouda.totalvoice.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AccessTokenInterceptor (val token: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestBuilder = request.newBuilder()
                .header("Access-Token", token)

        return chain.proceed(requestBuilder.build())
    }
}