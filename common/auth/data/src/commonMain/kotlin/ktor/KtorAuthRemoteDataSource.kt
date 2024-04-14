package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import kotlinx.coroutines.delay
import model.Token
import kotlin.random.Random

class KtorAuthRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun performLogin(request: KtorLoginRequest): Token {
        delay(1000L)
        return Token(token = Random.toString())
//        httpClient.post {
//            url {
//                path("login")
//                setBody(request)
//            }
//        }.body()
    }
}