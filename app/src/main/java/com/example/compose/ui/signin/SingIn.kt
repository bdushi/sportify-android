package com.example.compose.ui.signin

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue

@Composable
fun SignIn(authViewModel: AuthViewModel) {
    var username by savedInstanceState { "" }
    var password by savedInstanceState { "" }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "SignIn") }
            )
        },
        bodyContent = {
            Column {
                TextField(
                    value = username,
                    onValueChange = { username = it }
                )
                TextField(
                    value = password,
                    onValueChange = { password = it }
                )
                Button(onClick = {
                    authViewModel.login(username = username, password = password)
                }) {
                    Text(text = "SignIn")
                }
                Button(onClick = {}) {
                    Text(text = "Create New Account")
                }
            }
        }
    )
}