package com.example.petfinder.data.api

import com.example.petfinder.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PetApi {

    @Headers(
        "Content-Type': 'application/json",
        "Cache-Control: no-cache"
    )
    @GET("login")
    fun logIn(@Query("username") username: String,
              @Query("password") password: String): Call<LoginResponse>
}