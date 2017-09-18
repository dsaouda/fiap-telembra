package com.github.dsaouda.fiaptelembra.commands

import com.github.dsaouda.disque.Disque
import com.github.dsaouda.fiaptelembra.component.DisqueComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class DisqueServerCommands {

    @Autowired
    lateinit var disque: DisqueComponent

    @ShellMethod("Iniciar disque server")
    fun execute(): String {

        println(disque)

        return "FOIIII"
    }

}