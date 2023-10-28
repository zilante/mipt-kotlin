package com.mipt.kotlin.ktor.hw.repository

import com.mipt.kotlin.ktor.hw.model.Publication

interface PublicationRepository {

    fun getAll(): Collection<Publication>

    fun getById(id: Long): Publication?

    fun createPublication(publicationText: String): Publication

    fun updatePublication(id: Long, newText: String): Publication?
}
