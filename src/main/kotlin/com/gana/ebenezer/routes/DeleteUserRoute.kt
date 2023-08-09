package com.gana.ebenezer.routes

import com.gana.ebenezer.domain.model.ApiResponse
import com.gana.ebenezer.domain.model.EndPoint
import com.gana.ebenezer.domain.model.UserSession
import com.gana.ebenezer.domain.repository.UserDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

fun Routing.deleteUserRoute(
    app: Application, userDataSource: UserDataSource
) {

    authenticate("auth-session") {

        delete(EndPoint.DeleteUser.path) {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                call.respondRedirect(EndPoint.UnAuthorized.path)
                app.log.info("INVALID SESSION")
            } else {
                try {
                    call.sessions.clear<UserSession>()
                    deleteUser(
                        app = app, userId = userSession.id, userDataSource = userDataSource
                    )

                } catch (e: Exception) {
                    app.log.info("DELETE USER INFO ERROR $e")
                    call.respondRedirect(EndPoint.UnAuthorized.path)
                }
            }
        }
    }

}

private suspend fun PipelineContext<Unit, ApplicationCall>.deleteUser(
    app: Application, userId: String, userDataSource: UserDataSource
) {
    val result = userDataSource.deleteUser(userId = userId)
    if (result) {
        app.log.info("USER SUCCESSFULLY DELETED")
        call.respond(
            message = ApiResponse(
                success = true, message = "Successfully deleted user"
            ), status = HttpStatusCode.OK

        )
    } else {
        app.log.info("ERROR WHILE DELETING USER")
        call.respond(
            message = ApiResponse(success = false), status = HttpStatusCode.BadRequest
        )

    }

}