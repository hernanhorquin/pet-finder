package com.example.petfinder.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PetRequestGenerator {

    private val BASE_URL = "https://fathomless-fortress-88513.herokuapp.com/"

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .client(createHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createHttpClient(): OkHttpClient {


        val httpClient = OkHttpClient.Builder()

        httpClient.connectTimeout(60L, TimeUnit.SECONDS)
        httpClient.readTimeout(60L, TimeUnit.SECONDS)
        httpClient.writeTimeout(60L, TimeUnit.SECONDS)

        return httpClient.build()
    }

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}