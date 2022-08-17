package com.example.netronic.di.modules

import com.example.netronic.data.room.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val database: AppDatabase) {

    @Provides
    fun provideAppDatabase(): AppDatabase {
        return database
    }
}