package com.example.netronic.di

import androidx.lifecycle.ViewModel
import com.example.netronic.di.modules.ApiModule
import com.example.netronic.di.modules.DatabaseModule
import com.example.netronic.di.modules.RepositoryModule
import com.example.netronic.di.modules.ViewModelsModule
import com.example.netronic.ui.users.UsersFragment
import dagger.Component

@Component(modules = [
    ApiModule::class,
    RepositoryModule::class,
    ViewModelsModule::class,
    DatabaseModule::class,
])
interface AppComponent {

    fun inject(target: UsersFragment)

    val viewModelProducerSet: Set<Pair<String, () -> ViewModel>>
}