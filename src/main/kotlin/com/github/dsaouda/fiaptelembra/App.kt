package com.github.dsaouda.fiaptelembra

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App

fun main(args: Array<String>) {
    val cli = SpringApplication(App::class.java)
    cli.setWebEnvironment(true)
    cli.run(*args)
}