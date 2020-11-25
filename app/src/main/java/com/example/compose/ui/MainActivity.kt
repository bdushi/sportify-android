package com.example.compose.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.compose.ui.signin.AuthViewModel
import com.example.compose.ui.signin.SignIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModels()
//    private val leaveViewModel: LeaveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel.auth()
        authViewModel.success.observe(this, {
            if (it) {
                setContent { AnnualLeave() }
            } else {
                setContent { SignIn(authViewModel) }
            }
        })
    }
}