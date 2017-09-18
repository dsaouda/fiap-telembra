package com.github.dsaouda.disque

import org.apache.log4j.ConsoleAppender
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.PatternLayout
import java.time.LocalDateTime
import java.lang.System.console



fun main(args: Array<String>) {
    val disque = Disque("disque://192.168.33.10:7711")

    while (true) {
        val job = disque.deamonGetJob("queue")

        disque.ackjob(job.getId())

        println(job.body)
        println("RECEBIDA EM ${LocalDateTime.now()}")
        println("\n\n==============\n\n")
    }
}