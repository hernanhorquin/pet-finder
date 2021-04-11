package com.example.petfinder.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchen_recipes.ui.utils.Data
import com.example.kitchen_recipes.ui.utils.Result
import com.example.kitchen_recipes.ui.utils.Status
import com.example.petfinder.data.repository.PetRepository
import com.example.petfinder.data.repository.PetRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {

    private val petRepository: PetRepository = PetRepositoryImpl()

    private var _logIn = MutableLiveData<Data<Boolean>>()
    val logIn: LiveData<Data<Boolean>>
        get() = _logIn

    fun logIn(username: String, password: String) = viewModelScope.launch {
        _logIn.postValue(Data(responseType = Status.LOADING))
        when (val result = withContext(Dispatchers.IO) { petRepository.logIn(username, password) }) {
            is Result.Failure -> {
                _logIn.postValue(Data(responseType = Status.ERROR, error = result.exception))
            }
            is Result.Success -> {
                _logIn.postValue(Data(responseType = Status.SUCCESSFUL, data = result.data))
            }
        }    }
}