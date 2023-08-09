package com.gana.ebenezer.routes

import com.gana.ebenezer.domain.model.EndPoint
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.rootRoute(){
    get(EndPoint.Root.path) {
        call.respondText("Hello Ktor.... Welcome to Ktor server!")
    }
}