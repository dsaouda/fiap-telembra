package com.github.dsaouda.fiaptelembra.middleware

import com.github.dsaouda.fiaptelembra.repository.LoginRepository
import com.github.dsaouda.fiaptelembra.token.Token
import org.springframework.beans.factory.annotation.Autowired
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
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Order(2)
@Component
class Autorizacao : Filter {

    @Autowired
    private lateinit var repoLogin: LoginRepository

    override fun destroy() {}

    override fun init(filterConfig: FilterConfig) {}

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {

        val request = req as HttpServletRequest
        val response = res as HttpServletResponse

        val requestURI = request.servletPath

        val token = request.getHeader("x-api-key")

        if (requestURI.startsWith("/lembretes") || requestURI.startsWith("/pessoa")) {

            if (token.isNullOrEmpty()) {
                response.status = HttpStatus.FORBIDDEN.value()
                return
            }

            if (Token.hasNot(token)) {
                val login = repoLogin.findFirstByToken(token)

                if (login == null) {
                    response.status = HttpStatus.FORBIDDEN.value()
                    return
                }

                Token.add(login.token!!, login.cliente!!)
            }
        }

        chain.doFilter(req, res)
    }
}