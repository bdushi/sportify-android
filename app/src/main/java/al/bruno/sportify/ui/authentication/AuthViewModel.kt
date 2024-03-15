package al.bruno.sportify.ui.authentication

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import al.bruno.sportify.data.source.AuthRepository
import al.bruno.sportify.interceptor.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val token: Token
) : ViewModel() {

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    var loading  = mutableStateOf(false)
        private set

    fun auth() {
        viewModelScope.launch {
            authRepository.token().collect {
                _success.value = !it.isNullOrEmpty()
                token.token = it ?: ""
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    fun validateToken(token: String) {
        viewModelScope.launch {
            runCatching {
                authRepository.validateToken(token)
            }.onSuccess {
                if(it != null) {
                    authRepository.token(it)
                } else {
                    Log.e("TAG", "Token validation Failed")
                }
            }.onFailure {
                Log.e("TAG", "Server error ${it.message}")
            }
        }
    }

    fun login(username: String, password: String) {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                authRepository.auth(username = username, password = password)
            }.onSuccess {
                if(it != null) {
                    authRepository.token(it)
                } else {
                    Log.e("TAG", "Token validation Failed")
                }
            }.onFailure {
                Log.e("TAG", "Server error ${it.message}")
            }
        }
    }
}