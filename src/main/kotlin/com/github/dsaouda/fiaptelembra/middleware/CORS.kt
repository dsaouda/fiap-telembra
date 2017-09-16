package com.github.dsaouda.fiaptelembra.middleware

import java.io.IOException

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@Order(1)
@Component
class CORS : Filter {

    override fun destroy() {}

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, resp: ServletResponse, chain: FilterChain) {

        val request = req as HttpServletRequest
        val response = resp as HttpServletResponse

        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Credentials", "true") //permite armazenar cookie??
        //response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type")

        if (request.method == "OPTIONS") {
            response.status = HttpServletResponse.SC_OK
            return
        }

        chain.doFilter(request, response)
    }

    @Throws(ServletException::class)
    override fun init(config: FilterConfig) {

    }

}