package com.example.petfinder.data.repository

import com.example.kitchen_recipes.ui.utils.Result
import com.example.petfinder.data.model.Pet

interface PetRepository {

    fun getLostPets(): List<Pet>
    fun getFoundPets(): List<Pet>
    fun getUserChats()
    fun logIn(username: String, password: String): Result<Boolean>
}