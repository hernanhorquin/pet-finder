package com.example.petfinder.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("email")
    var email: String,
    @SerializedName("token")
    var token: String,
)