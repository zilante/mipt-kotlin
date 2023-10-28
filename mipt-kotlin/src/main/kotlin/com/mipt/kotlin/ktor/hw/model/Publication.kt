package com.mipt.kotlin.ktor.hw.model

import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Publication(
    val id: Long,
    var text: String,
    val createdAt: String,
    var updatedAt: String,
)
