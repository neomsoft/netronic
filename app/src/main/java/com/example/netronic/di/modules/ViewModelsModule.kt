package com.example.netronic.di.modules

import androidx.lifecycle.ViewModel
import com.example.netronic.data.repository.IDataRepository
import com.example.netronic.presentation.history.UsersHistoryViewModel
import com.example.netronic.presentation.users.UsersViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ViewModelsModule {

    @IntoSet
    @Provides
    fun provideUsersViewModel(
        repository: IDataRepository,
    ): Pair<String, () -> ViewModel> {
        return UsersViewModel::class.java.name to {
            UsersViewModel(
                repository = repository,
            )
        }
    }

    @IntoSet
    @Provides
    fun provideUsersHistoryViewModel(
        repository: IDataRepository,
    ): Pair<String, () -> ViewModel> {
        return UsersHistoryViewModel::class.java.name to {
            UsersHistoryViewModel(
                repository = repository,
            )
        }
    }
}