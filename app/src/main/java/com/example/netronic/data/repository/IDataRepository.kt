package com.example.netronic.data.repository

import com.example.netronic.data.entities.User

interface IDataRepository {

    suspend fun getRandomUsers(): List<User>

    suspend fun getRandomUsersHistory(): List<User>

    suspend fun saveRandomUsersToHistory(users: List<User>)
}