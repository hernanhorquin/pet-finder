package com.example.petfinder.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.kitchen_recipes.ui.utils.Status
import com.example.petfinder.MainActivity
import com.example.petfinder.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private var viewModel = SignInViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.signInButton.setOnClickListener {
            viewModel.logIn("matiaslato@gmail.com", "123456")
            //startActivity(Intent(this, MainActivity::class.java))
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
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        })
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

}