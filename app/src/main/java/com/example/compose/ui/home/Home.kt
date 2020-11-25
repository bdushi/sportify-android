package com.example.compose.ui.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable

@Composable
fun Home(
    addLeave: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "AppBar") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                icon = { Icon(Icons.Rounded.Add) },
                onClick = addLeave
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
        bodyContent = {
            // leaveListView(leave = leaveViewModel.leaves)
        })
}