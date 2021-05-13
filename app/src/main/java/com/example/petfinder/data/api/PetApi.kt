package com.example.petfinder.data.api

import com.example.petfinder.data.model.LoginRequest
import com.example.petfinder.data.model.LoginResponse
import com.example.petfinder.data.model.SignUpRequest
import com.example.petfinder.data.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface PetApi {

    @Headers(
        "Content-Type': 'application/json",
        "Cache-Control: no-cache"
    )
    @GET("auth/login")
    fun logIn(@Query("email") username: String,
              @Query("password") password: String): Call<LoginResponse>

    @POST("auth/singup")
    fun signUp(@Body model: SignUpRequest): Call<SignUpResponse>
}