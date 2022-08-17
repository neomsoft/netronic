package com.example.netronic.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * User. Клас який використовується в додатку.
 *
 * @param id ідентифікатор юзера.
 * @param name імя юзера.
 * @param photo фото юзера.
 * @param age вік юзера.
 * @param email електронна пошта юзера.
 * @param birthday дата народження юзера.
 */
@Parcelize
data class User(
    val id: String,
    val name: String,
    val photo: String,
    val age: Int,
    val email: String,
    val birthday: Date,
) : Parcelable
