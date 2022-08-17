package com.example.netronic.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.netronic.data.repository.IDataRepository
import com.example.netronic.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class UsersViewModel(
    private val repository: IDataRepository,
) : BaseViewModel() {

    val usersLiveData: LiveData<UsersState> = liveDataOf(UsersState.Empty)

    fun onBtnLoadClick() {
        usersLiveData.postValue(UsersState.Loading)

        viewModelScope.launch {
            try {
                val users = repository.getRandomUsers()
                repository.saveRandomUsersToHistory(users)
                usersLiveData.postValue(UsersState.Data(users))
            } catch (e: Exception) {
                usersLiveData.postValue(UsersState.Error(e))
            }
        }
    }
}