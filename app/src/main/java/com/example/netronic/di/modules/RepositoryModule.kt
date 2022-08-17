package com.example.netronic.di.modules

import com.example.netronic.data.repository.DataRepository
import com.example.netronic.data.repository.IDataRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideDataRepository(repository: DataRepository): IDataRepository
}