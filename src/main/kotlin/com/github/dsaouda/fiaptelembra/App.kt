package com.github.dsaouda.fiaptelembra

import com.github.dsaouda.fiaptelembra.cli.LembreteMessageBrokerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class App : CommandLineRunner {

    @Autowired
    private lateinit var pl: LembreteMessageBrokerService

    override fun run(args: Array<String>) {
        if (App.isCli(args)) {
            pl.execute()
        }
    }

    companion object{
        fun isCli(args: Array<String>) = args.size > 0 && args[0] == "cli"
    }

}

fun main(args: Array<String>) {
    val app = SpringApplication(App::class.java)

    //não iniciar a parte web, somente o terminal
    if (App.isCli(args)) {
        app.setWebEnvironment(false)
    }

    app.run(*args)
}