package com.gana.ebenezer.routes

import com.gana.ebenezer.domain.model.ApiResponse
import com.gana.ebenezer.domain.model.EndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.authorizedRoute(){

    authenticate("auth-session") {
        get(EndPoint.Authorized.path){
            call.respond(message = ApiResponse(success = true),
                status = HttpStatusCode.OK
            )
        }
    }


}