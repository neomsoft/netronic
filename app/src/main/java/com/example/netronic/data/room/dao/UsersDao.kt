package com.example.netronic.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.netronic.data.room.entities.UserEntity

@Dao
abstract class UsersDao {

    @Query("SELECT * FROM users")
    abstract fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUsers(items: List<UserEntity>)
}