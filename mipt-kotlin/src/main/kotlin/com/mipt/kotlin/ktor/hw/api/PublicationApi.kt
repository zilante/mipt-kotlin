package com.mipt.kotlin.ktor.hw.api

import com.mipt.kotlin.ktor.hw.model.CreatePublicationRequest
import com.mipt.kotlin.ktor.hw.model.UpdatePublicationRequest
import com.mipt.kotlin.ktor.hw.repository.PublicationRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.publicationApi() {
     routing {
         val publicationRepository by inject<PublicationRepository>()

         get("/publications") {
             val publications = publicationRepository.getAll()

             call.respond(publications)
         }

         get("/publications/{id}") {
             val publicationId = call.parameters["id"]?.toLong() ?: 0
             val publication = publicationRepository.getById(publicationId)

             if (publication == null) {
                 call.respond(HttpStatusCode.NotFound)
             } else {
                 call.respond(publication)
             }
         }

         put("/publications") {
             val request = call.receive<CreatePublicationRequest>()
             val createdPublication = publicationRepository.createPublication(request.text)

             call.respond(createdPublication)
         }

         patch("/publications/{id}") {
             val publicationId = call.parameters["id"]?.toLong() ?: 0
             val request = call.receive<UpdatePublicationRequest>()

             val updatedPublication = publicationRepository
                 .updatePublication(publicationId, request.text)

             if (updatedPublication == null) {
                 call.respond(HttpStatusCode.NotFound)
             } else {
                 call.respond(updatedPublication)
             }
         }
     }
}
