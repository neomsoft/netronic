package com.example.netronic.data.repository

import com.example.netronic.data.entities.User
import com.example.netronic.data.net.randomuser.RandomUserApi
import com.example.netronic.data.net.randomuser.entities.Nationalities
import com.example.netronic.data.net.randomuser.entities.Nationality
import com.example.netronic.data.net.randomuser.entities.User.Companion.toUser
import com.example.netronic.data.room.AppDatabase
import com.example.netronic.data.room.entities.UserEntity
import com.example.netronic.data.room.entities.UserEntity.Companion.toUser
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val database: AppDatabase,
    private val randomUserApi: RandomUserApi,
): IDataRepository {

    override suspend fun getRandomUsers(): List<User> = withContext(Dispatchers.IO) {
        val res = randomUserApi.getRandomUsers(
            count = 20,
            nationalities = Nationalities(listOf(Nationality.AU, Nationality.US))
        )

        return@withContext if (res is ApiResponse.Success) {
            res.data.results.map { it.toUser() }
        } else {
            when (res) {
                is ApiResponse.Failure.Error -> {
                    throw HttpException(res.response)
                }
                is ApiResponse.Failure.Exception -> {
                    throw RuntimeException(res.message)
                }
                else -> {
                    throw RuntimeException()
                }
            }
        }
    }

    override suspend fun getRandomUsersHistory(): List<User> {
        return database.usersDao.getUsers().map { it.toUser() }
    }

    override suspend fun saveRandomUsersToHistory(users: List<User>) {
        database.usersDao.insertUsers(users.map { UserEntity.from(it) })
    }
}