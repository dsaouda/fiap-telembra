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

@Order(2)
@Component
class Autorizacao : Filter {

    //@Autowired
    //private val usuarioSession: UsuarioSession? = null

    override fun destroy() {

    }

    override fun init(filterConfig: FilterConfig) {
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {

        val request = req as HttpServletRequest
        val response = res as HttpServletResponse

        val requestURI = request.servletPath

        println(requestURI)

        if (requestURI.startsWith("/rpc/") || requestURI.startsWith("/rest/")) {
            //if (usuarioSession!!.getId() == null) {
            //    response.status = HttpStatus.FORBIDDEN.value()
            //    return
            //}
        }

        chain.doFilter(req, res)
    }
}