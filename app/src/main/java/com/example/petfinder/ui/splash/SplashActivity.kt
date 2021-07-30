package com.example.petfinder.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petfinder.MainActivity
import com.example.petfinder.ui.login.SignInActivity
import com.example.petfinder.utils.SharedPreferencesHelper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (SharedPreferencesHelper.getInstance(this).isSessionLogged)
            startActivity(Intent(this, MainActivity::class.java))
        else
            startActivity(Intent(this, SignInActivity::class.java))

    }

    override fun onRestart() {
        super.onRestart()
        finishAndRemoveTask()
    }
}