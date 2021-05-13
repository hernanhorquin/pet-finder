package com.example.petfinder.data.repository

import com.example.kitchen_recipes.ui.utils.Result
import com.example.petfinder.data.PetRequestGenerator
import com.example.petfinder.data.api.PetApi
import com.example.petfinder.data.model.Pet
import com.example.petfinder.data.model.SignUpRequest

class PetRepositoryImpl : PetRepository {

    private val apiService = PetRequestGenerator()

    override fun logIn(username: String, password: String): Result<Boolean> {
        val callResponse = apiService.createService(PetApi::class.java)
            .logIn(username, password)
        val response = callResponse.execute()
        response?.let { _ ->
            if (response.isSuccessful) {
                response.body()?.let { _ ->
                    return Result.Success(true)
                }
                return Result.Success(false)
            }

        }
        return Result.Failure(Exception("BAD_REQUEST"))
    }

    override fun signUp(email: String, password: String, firstName: String, lastName: String, cellphone: String, address: String): Result<Boolean> {
        val callResponse = apiService.createService(PetApi::class.java)
            .signUp(SignUpRequest(firstName, lastName, email, password, cellphone, address))
        val response = callResponse.execute()
        response?.let { _ ->
            if (response.isSuccessful) {
                response.body()?.let { _ ->
                    return Result.Success(true)
                }
                return Result.Success(false)
            }

        }
        return Result.Failure(Exception("BAD_REQUEST"))
    }

    override fun getLostPets(): List<Pet> {
        TODO("Not yet implemented")
    }

    override fun getFoundPets(): List<Pet> {
        TODO("Not yet implemented")
    }

    override fun getUserChats() {
        TODO("Not yet implemented")
    }
}