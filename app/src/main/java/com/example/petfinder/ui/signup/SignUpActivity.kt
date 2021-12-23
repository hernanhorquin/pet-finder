package com.example.petfinder.ui.signup

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchen_recipes.ui.utils.Status
import com.example.petfinder.MainActivity
import com.example.petfinder.R
import com.example.petfinder.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private val viewModel: SignUpViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.birthday.setOnClickListener {
            showDatePicker()
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        binding.signUpButton.setOnClickListener {
            if (allFieldsCompleted())
                viewModel.signUp("Hernan", "Horquin", "123456", "155778469", "Acha 2145", "hhorquin")
            else
                Toast.makeText(this, "Complete los datos faltantes", Toast.LENGTH_SHORT).show()
        }

        viewModel.signUp.observe(this, {
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

    private fun allFieldsCompleted(): Boolean {
        return (binding.email.text.isNotBlank() && binding.password.text.isNotBlank() && binding.name.text.isNotBlank() && binding.lastname.text.isNotBlank() && binding.cellphone.text.isNotBlank() && binding.birthday.text.isNotBlank() && binding.address.text.isNotBlank())
    }

    private fun showDatePicker() {
        val c: Calendar = Calendar.getInstance()

        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        val year: Int = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(
            this,
            { _, _, _, dayOfMonth ->
                val mesActual = month + 1
                val formatDay =
                    if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString()
                val formatMonth =
                    if (mesActual < 10) "0$mesActual" else mesActual.toString()
                binding.birthday.text = "$formatDay/$formatMonth/$year"
            },
            year, month, day
        )
        picker.show()
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }
}