package com.example.petfinder.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PetRequestGenerator {

    private val BASE_URL = "https://fathomless-fortress-88513.herokuapp.com/"

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor { chain ->
        val defaultRequest = chain.request()

        val defaulthttpUrl = defaultRequest.url()
        val httpUrl = defaulthttpUrl.newBuilder()
            .build()

        val requestBuilder = defaultRequest.newBuilder().url(httpUrl)
        chain.proceed(requestBuilder.build())
    }

    val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }
}