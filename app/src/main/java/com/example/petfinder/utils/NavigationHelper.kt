package com.example.petfinder.utils

import android.app.Activity
import android.content.Intent
import com.example.petfinder.data.model.Pet
import com.example.petfinder.ui.detail.PetDetailActivity

class NavigationHelper {

    fun goToDetailActivity(parentActivity: Activity, pet: Pet) {
        val intent = Intent(parentActivity, PetDetailActivity::class.java)
        intent.putExtra(PetDetailActivity.PET, pet)
        parentActivity.startActivity(intent)
    }
}