package com.mipt.kotlin.ktor.hw.model

import kotlinx.serialization.Serializable

@Serializable
data class CreatePublicationRequest(
    val text: String,
)
