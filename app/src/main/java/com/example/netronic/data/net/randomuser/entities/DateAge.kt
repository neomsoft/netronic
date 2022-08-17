package com.example.netronic.data.net.randomuser.entities

import java.util.*

/**
 * Дата та кількість років з тієї дати (вік).
 *
 * @param date дата.
 * @param age вік.
 */
data class DateAge(
    val date: Date,
    val age: Int
)
