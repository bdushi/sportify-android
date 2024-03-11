package al.bruno.sportify.ui.authentication

import al.bruno.sportify.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun SignIn(authViewModel: AuthViewModel) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Box(
//        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.Center),
            visible = authViewModel.loading.value
        ) {
            CircularProgressIndicator()
        }

        AnimatedVisibility(
            visible = !authViewModel.loading.value
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = { Text(text = stringResource(id = R.string.username)) },
                    value = username,
                    onValueChange = { username = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                    ),
                    isError = username.isEmpty(),
                )

                TextField(

                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    label = { Text(text = stringResource(id = R.string.password)) },
                    value = password,
                    onValueChange = { password = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
//                                    onImeActionPerformed = { imeAction, softwareKeyboardController ->
//                                        run {
//                                            if (imeAction == ImeAction.Done) {
//                                                softwareKeyboardController?.hideSoftwareKeyboard()
//                                                authViewModel.login(
//                                                    username = username,
//                                                    password = password
//                                                )
//                                            }
//                                        }
//                                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = password.isEmpty(),
//                                    trailingIcon = {  Icon(imageVector = Icons.Filled.Lock, contentDescription = null) },
                )
                Button(
                    enabled = username.isNotEmpty() && password.isNotEmpty(),
                    modifier = Modifier
                        .padding(8.dp),
                    onClick = {
                        authViewModel.login(
                            username = username,
                            password = password
                        )
                    }
                ) {
                    Text(text = stringResource(id = R.string.sign_in))
                }
            }
        }
    }
}