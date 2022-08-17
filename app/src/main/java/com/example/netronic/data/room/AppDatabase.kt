package com.example.netronic.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.netronic.data.room.dao.UsersDao
import com.example.netronic.data.room.entities.UserEntity

@Database(
    version = 1,
    entities = [UserEntity::class],
)
abstract class AppDatabase : RoomDatabase() {

    abstract val usersDao: UsersDao

    companion object {

        private const val DATABASE_NAME = "database"

        fun getInstance(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }
}