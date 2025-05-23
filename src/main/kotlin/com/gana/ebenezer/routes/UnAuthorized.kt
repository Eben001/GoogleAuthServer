package com.gana.ebenezer.routes

import com.gana.ebenezer.domain.model.EndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.unauthorizedRoute(){
    get(EndPoint.UnAuthorized.path){
        call.respond(
            message = "Not Authorized",
            status = HttpStatusCode.Unauthorized
        )
    }
}