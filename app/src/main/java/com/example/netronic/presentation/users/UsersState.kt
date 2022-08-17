package com.example.netronic.presentation.users

import com.example.netronic.data.entities.User

sealed class UsersState {

    object Empty: UsersState()

    object Loading: UsersState()

    data class  Error(
        val e: Exception
    ): UsersState()

    data class Data(
        val users: List<User>
    ): UsersState()
}
