package com.example.petfinder.ui.signup

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

class SignUpViewModel: ViewModel() {

    private val petRepository: PetRepository = PetRepositoryImpl()

    private var _signUp = MutableLiveData<Data<Boolean>>()
    val signUp: LiveData<Data<Boolean>>
        get() = _signUp

    fun signUp(email: String, password: String, firstName: String, lastName: String, cellphone: String, address: String) = viewModelScope.launch {
        _signUp.postValue(Data(responseType = Status.LOADING))
        when (val result =
            withContext(Dispatchers.IO) { petRepository.signUp(email, password, firstName, lastName, cellphone, address) }) {
            is Result.Failure -> {
                _signUp.postValue(Data(responseType = Status.ERROR, error = result.exception))
            }
            is Result.Success -> {
                _signUp.postValue(Data(responseType = Status.SUCCESSFUL, data = result.data))
            }
        }
    }
}