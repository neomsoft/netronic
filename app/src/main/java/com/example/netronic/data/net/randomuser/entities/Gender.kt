package com.example.netronic.data.net.randomuser.entities

import com.google.gson.JsonDeserializer

enum class Gender {
    MALE,
    FEMALE;

    override fun toString(): String {
        return super.toString().lowercase()
    }

    companion object {

        val JSON_DESERIALIZER = JsonDeserializer { json, _, _ -> values()
            .find { it.toString() == json.asString }
            ?: throw IllegalStateException()
        }
    }
}