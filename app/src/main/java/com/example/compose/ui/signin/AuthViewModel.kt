package com.example.compose.ui.signin

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.data.source.AuthRepository
import com.example.compose.interceptor.AuthInterceptor
import com.example.compose.interceptor.ErrorHandler
import com.example.compose.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(
    private val authRepository: AuthRepository,
    private val authInterceptor: AuthInterceptor,
    private val errorHandler: ErrorHandler) : ViewModel() {

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun auth() {
        viewModelScope.launch {
            authRepository.token().collect {
                _success.value = !it.isNullOrBlank()
            }
        }
    }

    fun fake() {
        viewModelScope.launch {
            authRepository.token("token")
        }
    }

    fun login(username: String, password: String) {
        _loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.postValue(false)
                val response = authRepository.auth(username = username, password = password)
                if(response.isSuccessful) {
                    val token = response.headers()["Authorization"]
                    if(token != null) {
                        authInterceptor.token = token
                        authRepository.token(token = token)
//                        val userResponse = userRepository.user(username!!)
//                        if(userResponse.isSuccessful) {
//                            val user: User = userResponse.body()
//                            user.token = token
//                            if (userRepository.insert(user) != (-1).toLong()) {
//                                _success.postValue("Success")
//                            } else {
//                                _error.postValue("Authentification Falid")
//                            }
//                        } else {
//                            _error.postValue("Authentification Falid")
//                        }
                    } else {
                        _error.postValue("Authentification Falid")
                    }
                } else {
                    _error.postValue(errorHandler.parseError(response).message)
                }
            } catch (ex: Exception) {
                _loading.postValue(false)
                _error.postValue(ex.message)
                Log.d(AuthViewModel::class.java.name, "Ex:" + ex.message.toString())
            }
        }
    }
}