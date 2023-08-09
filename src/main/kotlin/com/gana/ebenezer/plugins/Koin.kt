package com.gana.ebenezer.plugins

import com.gana.ebenezer.di.koinModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin(){
    install(Koin){
        modules(koinModule)
    }
}