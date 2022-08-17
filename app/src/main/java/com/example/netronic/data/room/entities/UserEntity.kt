package com.example.netronic.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.netronic.data.entities.User
import java.util.*

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    val id: String,
    val name: String,
    val photo: String,
    val age: Int,
    val email: String,
    val birthday: Long,
) {

    companion object {
        fun from(user: User) = UserEntity(
            id = user.id,
            name = user.name,
            photo = user.photo,
            age = user.age,
            email = user.email,
            birthday = user.birthday.time,
        )

        fun UserEntity.toUser() = User(
            id = id,
            name = name,
            photo = photo,
            age = age,
            email = email,
            birthday = Date(birthday),
        )
    }
}