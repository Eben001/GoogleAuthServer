package com.gana.ebenezer.plugins

import com.gana.ebenezer.domain.repository.UserDataSource
import com.gana.ebenezer.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    routing {
        val userDataSource:UserDataSource by inject(UserDataSource::class.java)
        rootRoute()
        tokenVerificationRoute(application, userDataSource)
        getUserInfoRoute(application, userDataSource)
        updateUserRoute(application, userDataSource)
        deleteUserRoute(application, userDataSource)
        signOutUser(application)
        authorizedRoute()
        unauthorizedRoute()
    }
}
