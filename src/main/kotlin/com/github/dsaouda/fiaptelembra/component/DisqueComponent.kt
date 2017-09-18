package com.github.dsaouda.fiaptelembra.component

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DisqueComponent {

    @Value("\${disque}")
    private lateinit var host: String

    constructor() {
        println("\n\n=======================\n\n")
        println(host)
        println("\n\n=======================\n\n")
    }
}