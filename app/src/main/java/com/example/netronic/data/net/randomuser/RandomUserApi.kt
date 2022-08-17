package com.example.netronic.data.net.randomuser

import com.example.netronic.data.net.randomuser.entities.Gender
import com.example.netronic.data.net.randomuser.entities.Nationalities
import com.example.netronic.data.net.randomuser.entities.Nationality
import com.example.netronic.data.net.randomuser.entities.UsersResponse
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * API for https://randomuser.me.
 *
 * @see <a href="https://randomuser.me/documentation">Documentation</a>
 */
interface RandomUserApi {

    /**
     * Get a list of random users.
     *
     * @param count кількіть користувачів.
     * @param gender стать. Type [Gender].
     * @param nationalities національності користувачів. Type [Nationalities].
     *
     * @return users list. Type [UsersResponse]
     *
     * @see <a href="https://randomuser.me/documentation#howto">Documentation</a>.
     */
    @GET("?")
    suspend fun getRandomUsers(
        @Query("results")
        count: Int? = null,

        @Query("gender")
        gender: Gender? = null,

        @Query("nat")
        nationalities: Nationalities? = null,
    ): ApiResponse<UsersResponse>

    companion object {

        private const val BASE_URL = "https://randomuser.me/api/"
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

        fun createApi(): RandomUserApi {
            val gson = GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .registerTypeAdapter(Gender::class.java, Gender.JSON_DESERIALIZER)
                .registerTypeAdapter(Nationality::class.java, Nationality.JSON_DESERIALIZER)
                .create()

            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            return Retrofit
                .Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
                .build()
                .create(RandomUserApi::class.java)
        }
    }
}