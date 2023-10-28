package com.mipt.kotlin.ktor.hw.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdatePublicationRequest(
    val text: String,
)
