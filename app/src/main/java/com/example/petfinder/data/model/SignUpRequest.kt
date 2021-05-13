package com.example.petfinder.data.model

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("firstName")
    var firstname: String,
    @SerializedName("lastname")
    var lastname: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("cellphone")
    var cellphone: String,
    @SerializedName("adrress")
    var adrress: String,
    @SerializedName("email")
    var email: String
)
