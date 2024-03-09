package al.bruno.sportify.ui.authentication

import al.bruno.sportify.R
import al.bruno.sportify.nav.Destinations
import al.bruno.sportify.ui.SignInButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.common.SignInButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Authentication(
    authViewModel: AuthViewModel,
    signInWithGoogle : () -> Unit
) {
    var isLoading by rememberSaveable { mutableStateOf(false) }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.Authentication) {
        composable(Destinations.Authentication) {
            Column(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextButton(
                    onClick = {
                        navController.navigate(Destinations.SignIn)
                    },
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(text = "Sign In")
                }
                SignInButton(
                    text = "Sign in with Google",
                    loadingText = "Signing in...",
                    isLoading = isLoading,
                    icon = painterResource(id = R.drawable.ic_google_logo),
                    onClick = {
                        isLoading = true
                        signInWithGoogle.invoke()
                    }
                )
            }
        }
        composable(Destinations.SignIn) {
            SignIn(authViewModel)
        }
    }
}