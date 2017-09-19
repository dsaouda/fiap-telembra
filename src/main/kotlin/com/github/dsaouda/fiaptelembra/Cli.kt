package com.github.dsaouda.fiaptelembra

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Cli

fun main(args: Array<String>) {
    val cli = SpringApplication(Cli::class.java)
    cli.setWebEnvironment(false)
    cli.run(*args)
}