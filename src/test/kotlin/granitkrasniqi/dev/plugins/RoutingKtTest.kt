package granitkrasniqi.dev.plugins

import granitkrasniqi.dev.domain.PostRandomRequest
import granitkrasniqi.dev.domain.PostRandomResponse
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutingKtTest {

    @Test
    fun `PostRandomRequest returns the first sent name successfully`() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                gson()
            }
        }
        val response = client.post("/random") {
            contentType(ContentType.Application.Json)
            setBody(PostRandomRequest(names = listOf("Test Name", "Test Second Name")))
        }

        assertEquals(HttpStatusCode.Created, response.status)
        assertEquals(PostRandomResponse("Test Name"), response.body())
    }

}