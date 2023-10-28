package com.mipt.kotlin.ktor.hw

import com.mipt.kotlin.ktor.hw.repository.PublicationRepository
import com.mipt.kotlin.ktor.hw.repository.impl.PublicationRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module


val publicationsModule = module {
    singleOf(::PublicationRepositoryImpl) bind PublicationRepository::class
}
