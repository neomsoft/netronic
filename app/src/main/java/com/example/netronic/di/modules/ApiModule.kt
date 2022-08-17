package com.example.netronic.di.modules

import com.example.netronic.data.net.randomuser.RandomUserApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideRandomUserApi(): RandomUserApi {
        return RandomUserApi.createApi()
    }
}