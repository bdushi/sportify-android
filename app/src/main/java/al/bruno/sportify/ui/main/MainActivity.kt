package al.bruno.sportify.ui.main

import al.bruno.sportify.BuildConfig.GOOGLE_CLIENT_ID
import al.bruno.sportify.theme.SportifyTheme
import al.bruno.sportify.ui.authentication.AuthViewModel
import al.bruno.sportify.ui.authentication.Authentication
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialRequest.Builder
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val credentialManager: CredentialManager = CredentialManager.create(this)
    private val authViewModel: AuthViewModel by viewModel()
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    /**
     * @link https://developer.android.com/training/sign-in/credential-manager
     */
    private val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setServerClientId(GOOGLE_CLIENT_ID)
        .build()

    private var request: GetCredentialRequest = Builder()
        .addCredentialOption(googleIdOption)
        .build()

    private suspend fun auth() {
        val result = credentialManager.getCredential(
            request = request,
            context = this,
        )
        try {
            when (val credential = result.credential) {
                is CustomCredential -> {
                    if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                        try {
                            val googleIdTokenCredential =
                                GoogleIdTokenCredential.createFrom(credential.data)
                            authViewModel.validateToken(googleIdTokenCredential.idToken)
                        } catch (e: GoogleIdTokenParsingException) {
                            Log.e(TAG, "Received an invalid google id token response", e)
                        }
                    } else {
                        Log.e(TAG, "Unexpected type of credential")
                    }
                }
                else -> {
                    Log.e(TAG, "Unexpected type of credential")
                }
            }

        } catch (e: GetCredentialException) {
            Log.e(TAG, e.message.toString())
        }
    }

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel.auth()
        authViewModel.success.observe(this) {
            if (it) {
                setContent {
                    SportifyTheme {
                        MainScreen()
                    }
                }
            } else {
                setContent {
                    SportifyTheme {
                        Authentication(authViewModel) {
                            scope.launch {
                                auth()
                            }
                        }
                    }
                }
            }
        }
    }
}

const val TAG = "SPORTIFY_AUTH"
