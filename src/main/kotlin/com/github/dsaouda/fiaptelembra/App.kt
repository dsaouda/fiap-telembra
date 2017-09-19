package com.github.dsaouda.fiaptelembra

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App

fun main(args: Array<String>) {
    val app = SpringApplication(App::class.java)

    //não iniciar a parte web, somente o terminal
    if (args.size > 0 && args[0] == "cli") {
        app.setWebEnvironment(false)
    }

    app.run(*args)
}