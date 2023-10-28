package com.mipt.kotlin.ktor.hw.repository.impl

import com.mipt.kotlin.ktor.hw.model.Publication
import com.mipt.kotlin.ktor.hw.repository.PublicationRepository
import java.time.Instant
import kotlin.random.Random

class PublicationRepositoryImpl: PublicationRepository {

    private val publications: MutableSet<Publication> = mutableSetOf()
    override fun getAll(): Collection<Publication> {
        return publications.toList()
    }

    override fun getById(id: Long): Publication? {
        return publications.find { it.id == id }
    }

    override fun createPublication(publicationText: String): Publication {
        val now = Instant.now().toString()
        val createdPublication = Publication(
            id = Random.nextLong(),
            text = publicationText,
            createdAt = now,
            updatedAt = now,
        )
        publications.add(createdPublication)

        return createdPublication
    }

    override fun updatePublication(id: Long, newText: String): Publication? {
        return publications.find { it.id == id }?.apply {
            text = newText
            updatedAt = Instant.now().toString()
        }
    }
}
