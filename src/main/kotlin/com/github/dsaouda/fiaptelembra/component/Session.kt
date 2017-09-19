package com.github.dsaouda.fiaptelembra.component

import com.github.dsaouda.fiaptelembra.model.Cliente
import com.github.dsaouda.fiaptelembra.token.Token
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope
import javax.servlet.http.HttpServletRequest

@RequestScope
@Component
class Session {

    @Autowired
    private lateinit var request: HttpServletRequest

    fun cliente(): Cliente {
        return Token.get(request.getHeader("x-api-key"))!!
    }

}