package com.example.netronic.data.net.randomuser.entities

import com.google.gson.JsonDeserializer

enum class Nationality {
    AU, BR, CA, CH, DE, DK, ES, FI, FR, GB, IE, IN, IR, MX, NL, NO, NZ, RS, TR, UA, US;

    companion object {

        val JSON_DESERIALIZER = JsonDeserializer { json, _, _ -> values()
            .find { it.toString() == json.asString }
            ?: throw IllegalStateException()
        }
    }
}