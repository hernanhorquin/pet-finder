package com.example.petfinder.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kitchen_recipes.ui.utils.Status
import com.example.petfinder.MainActivity
import com.example.petfinder.databinding.ActivitySignInBinding
import com.example.petfinder.ui.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private var viewModel = SignInViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (getLoginSharedPreferences())
//            startActivity(Intent(this, MainActivity::class.java))

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

            //if (allFieldsCompleted())
                //viewModel.logIn("matiaslato@gmail.com", "123456")
//            else
//                Toast.makeText(this, "Complete los datos", Toast.LENGTH_SHORT).show()
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        viewModel.logIn.observe(this, {
            when (it.responseType) {
                Status.ERROR -> {
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
                Status.SUCCESSFUL -> {
                    hideLoading()
                    setLoginSharedPreferences()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        })
    }

    private fun setLoginSharedPreferences() {
        val sharedPreferences = this.getPreferences(MODE_PRIVATE)
        sharedPreferences.edit()
            .putBoolean("SHARED_PREFERENCES_KEEP_SESSION", true)
            .apply()
    }

    private fun getLoginSharedPreferences(): Boolean {
        return this.getPreferences(MODE_PRIVATE).getBoolean(
            "SHARED_PREFERENCES_KEEP_SESSION",
            false
        )
    }

    private fun allFieldsCompleted(): Boolean {
        return (binding.email.text.isNotBlank() && binding.password.text.isNotBlank())
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }
}