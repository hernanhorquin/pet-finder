package com.example.petfinder.data.repository

import android.util.Log
import com.example.kitchen_recipes.ui.utils.Result
import com.example.petfinder.data.PetRequestGenerator
import com.example.petfinder.data.api.PetApi
import com.example.petfinder.data.model.LoginResponse
import com.example.petfinder.data.model.Pet

class PetRepositoryImpl : PetRepository {

    private val apiService = PetRequestGenerator()

    override fun getLostPets(): List<Pet> {
        TODO("Not yet implemented")
    }

    override fun getFoundPets(): List<Pet> {
        TODO("Not yet implemented")
    }

    override fun getUserChats() {
        TODO("Not yet implemented")
    }

    override fun logIn(username: String, password: String): Result<Boolean> {
        val callResponse = apiService.createService(PetApi::class.java)
            .logIn(username, password)
        val response = callResponse.execute()
        response?.let { _ ->
            if (response.isSuccessful) {
                response.body()?.let { _ ->
                    Log.d("test", response.body()?.token.orEmpty())
                    return Result.Success(true)
                }
                return Result.Success(false)
            }

        }
        return Result.Failure(Exception("BAD_REQUEST"))
    }
}