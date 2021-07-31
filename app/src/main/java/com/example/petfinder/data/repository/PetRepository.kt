package com.example.petfinder.data.repository

import com.example.kitchen_recipes.ui.utils.Result
import com.example.petfinder.data.model.Pet

interface PetRepository {
    fun logIn(username: String, password: String): Result<Boolean>

    fun signUp(email: String, password: String, firstName: String, lastName: String, cellphone: String, address: String): Result<Boolean>

    fun getLostPets(): List<Pet>

    fun getFoundPets(): List<Pet>

    fun getUserChats()
}