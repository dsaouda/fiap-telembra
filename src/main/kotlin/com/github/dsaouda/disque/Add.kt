package com.github.dsaouda.disque

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


fun main(args: Array<String>) {

    val disque = Disque("disque://192.168.33.10:7711")
    val id1 = disque.addJob("queue", "executado direto ${LocalDateTime.now()}")


    val date = LocalDate.now()
    val time = LocalTime.of(14,50,0)
    val executar = LocalDateTime.of(date, time)
    val id2 = disque.addScheduleJob("queue", "mensagem agendada criada em ${LocalDateTime.now()} para executar em ${executar}", executar)

    println(id1)
    println(id2)
}
