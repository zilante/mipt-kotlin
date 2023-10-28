package com.mipt.kotlin.ktor.hw

import com.mipt.kotlin.ktor.hw.api.publicationApi
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080) {
        configureServer()

        publicationApi()
    }.start(wait = true)
}

fun Application.configureServer() {
    install(Koin) {
        modules(publicationsModule)
    }
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }
}
