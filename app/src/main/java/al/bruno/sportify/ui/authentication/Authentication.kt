package al.bruno.sportify.ui.authentication

import al.bruno.sportify.R
import al.bruno.sportify.ui.SignInButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Authentication(
    authViewModel: AuthViewModel,
    signInWithGoogle: () -> Unit
) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sportify", textAlign = TextAlign.Center, fontSize = 48.sp)
            SignIn(authViewModel = authViewModel)
            SignInButton(
                text = "Sign in with Google",
                loadingText = "Signing in...",
                isLoading = false,
                icon = painterResource(id = R.drawable.ic_google_logo),
                onClick = {
                    signInWithGoogle.invoke()
                }
            )
        }
    }
}