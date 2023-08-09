package com.gana.ebenezer

import com.gana.ebenezer.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureAuth()
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureSession()
}
