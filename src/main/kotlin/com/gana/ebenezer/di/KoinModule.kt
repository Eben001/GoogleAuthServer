package com.gana.ebenezer.di

import com.gana.ebenezer.data.repository.UserDataSourceImpl
import com.gana.ebenezer.domain.repository.UserDataSource
import com.gana.ebenezer.util.Constants.DATABASE_NAME
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val koinModule = module {
    single {
        KMongo.createClient(System.getenv("MONGODB_URI"))
            .coroutine
            .getDatabase(DATABASE_NAME)
    }

    single<UserDataSource>{
        UserDataSourceImpl(get())
    }

}