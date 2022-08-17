package com.example.netronic.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.netronic.data.repository.IDataRepository
import com.example.netronic.presentation.base.BaseViewModel
import com.example.netronic.presentation.users.UsersState
import kotlinx.coroutines.launch

class UsersHistoryViewModel(
    private val repository: IDataRepository,
) : BaseViewModel() {

    val usersLiveData: LiveData<UsersState> = liveDataOf(UsersState.Loading)

    init {
        viewModelScope.launch {
            try {
                val users = repository.getRandomUsersHistory()

                if (users.isEmpty()) {
                    usersLiveData.postValue(UsersState.Empty)
                } else {
                    usersLiveData.postValue(UsersState.Data(users))
                }
            } catch (e: Exception) {
                usersLiveData.postValue(UsersState.Error(e))
            }
        }

    }
}