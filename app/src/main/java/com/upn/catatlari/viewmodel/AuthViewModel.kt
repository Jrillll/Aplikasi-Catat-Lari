package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.upn.catatlari.model.AppDatabase
import com.upn.catatlari.model.User
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    private val _registerStatus = MutableLiveData<Boolean>()
    val registerStatus: LiveData<Boolean> = _registerStatus

    private val _loginStatus = MutableLiveData<User?>()
    val loginStatus: LiveData<User?> = _loginStatus

    fun register(user: User) {
        viewModelScope.launch {
            try {
                userDao.insertUser(user)
                _registerStatus.postValue(true)
            } catch (e: Exception) {
                _registerStatus.postValue(false)
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userDao.getUserByEmail(email)
            if (user != null && user.password == password) {
                _loginStatus.postValue(user)
            } else {
                _loginStatus.postValue(null)
            }
        }
    }
}