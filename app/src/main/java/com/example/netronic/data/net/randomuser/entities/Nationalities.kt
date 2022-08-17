package com.example.netronic.data.net.randomuser.entities

data class Nationalities(
    val nationalities: List<Nationality>
) {

    override fun toString(): String {
        return nationalities.joinToString(",").lowercase()
    }
}