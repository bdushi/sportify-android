package al.bruno.sportify.ui

import al.bruno.sportify.ui.authentication.AuthViewModel
import al.bruno.sportify.ui.authentication.Authentication
import al.bruno.sportify.ui.home.EventViewModel
import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.ExperimentalMaterial3Api
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModel()
    private val eventViewModel: EventViewModel by viewModel()
    private val oneTapClient: SignInClient by lazy {
        Identity.getSignInClient(this)
    }
    private val request: GetSignInIntentRequest by lazy {
        GetSignInIntentRequest.builder()
            .setServerClientId("651311705711-4ef9uig8ie1kh6jpfl01dedhi884b55h.apps.googleusercontent.com")
            .build()
    }

    private val handler =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
            try {
                val credential = oneTapClient.getSignInCredentialFromIntent(it.data)
                credential.googleIdToken?.let { it1 -> authViewModel.validateToken(it1) }
            } catch (ex: Exception) {
                Snackbar
                    .make(
                        findViewById(android.R.id.content),
                        "Error ${ex.message} ${ex.cause}",
                        Snackbar.LENGTH_SHORT
                    )
                    .show()
            }
        }

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel.auth()
        authViewModel.success.observe(this) {
            if (it) {
                setContent {
                    Sportify({

                    }, eventViewModel, authViewModel)
                }
            } else {
                setContent {
                    Authentication(authViewModel) {
                        oneTapClient
                            .getSignInIntent(request)
                            .addOnSuccessListener { result ->
                                handler.launch(
                                    IntentSenderRequest.Builder(
                                        result.intentSender
                                    ).build()
                                )
                            }
                            .addOnFailureListener { e ->
                                Snackbar
                                    .make(
                                        findViewById(android.R.id.content),
                                        "Google Sign-in failed ${e.message}",
                                        Snackbar.LENGTH_SHORT
                                    )
                                    .show()
                            }
                    }
                }
            }
        }
    }
}
