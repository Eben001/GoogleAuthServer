package com.gana.ebenezer.plugins

import com.gana.ebenezer.domain.model.EndPoint
import com.gana.ebenezer.domain.model.UserSession
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*

fun Application.configureAuth(){
    install(Authentication){
        session<UserSession>(name = "auth-session"){
            validate { session->
                session
            }

            challenge{
                call.respondRedirect(EndPoint.UnAuthorized.path)
            }
        }
    }
}