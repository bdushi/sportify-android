package al.bruno.sportify.ui.signin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import al.bruno.sportify.nav.Destinations
import al.bruno.sportify.ui.signup.SignUp
import al.bruno.sportify.R

@ExperimentalAnimationApi
@Composable
fun SignIn(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    MaterialTheme {
        NavHost(navController = navController, startDestination = Destinations.SignIn) {
            composable(Destinations.SignIn) {
                Scaffold(
                        topBar = {
                            TopAppBar(
                                    title = { Text(text = stringResource(id = R.string.sign_in_title)) }
                            )
                        }
                ) {
                    it.calculateBottomPadding()
                    Box(
                        modifier = Modifier.fillMaxSize(),
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
                                modifier = Modifier
                                    .padding(24.dp),
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
                                        authViewModel.login(username = username, password = password)
                                    }
                                ) {
                                    Text(text = stringResource(id = R.string.sign_in))
                                }
                                Button(
                                    onClick = {
                                        navController.navigate(Destinations.SignUp)
                                    }
                                ) {
                                    Text(text = stringResource(id = R.string.create_new_account))
                                }
                            }
                        }
                    }
                }
            }
            composable(Destinations.SignUp) {
                SignUp(navigateUp = {
                    navController.popBackStack()
                })
            }
        }
    }
}