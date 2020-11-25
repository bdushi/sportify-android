package com.example.compose.ui.addleave

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AddLeave(
        navigateUp: () -> Unit
) {
    Scaffold(
            topBar = {
                TopAppBar(
                        elevation = 0.dp,
                        title = { Text(text = "Add Leave") },
                        navigationIcon = {
                            IconButton(onClick = navigateUp) {
                                Icon(Icons.Rounded.ArrowBack)
                            }
                        },
                        actions = {
                            Button(
                                    onClick = {
                                        navigateUp()
                                    }
                            ) {
                                Text("Save")
                            }
                        }
                )
            },
            bodyContent = {
                Text(text = "Test")
            })
}