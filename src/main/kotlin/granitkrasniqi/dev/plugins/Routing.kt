package granitkrasniqi.dev.plugins

import granitkrasniqi.dev.domain.PostRandomRequest
import granitkrasniqi.dev.domain.PostRandomResponse
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/random") {
            val request = call.receive<PostRandomRequest>()
            val name = request.names.first()
            val result = PostRandomResponse(random = name)
            call.respond(message = result, status = HttpStatusCode.Created)
        }

    }
}
