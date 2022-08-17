package com.example.netronic

import android.app.Application
import com.example.netronic.data.room.AppDatabase
import com.example.netronic.di.AppComponent
import com.example.netronic.di.DaggerAppComponent
import com.example.netronic.di.modules.DatabaseModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        sAppComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(AppDatabase.getInstance(this)))
            .build()
    }

    companion object {
        private var sAppComponent: AppComponent? = null

        val appComponent: AppComponent get() {
            return sAppComponent!!
        }
    }
}