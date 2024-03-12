package al.bruno.sportify.ui.home

import al.bruno.sportify.R
import al.bruno.sportify.navigation.BottomNavigation
import al.bruno.sportify.navigation.BottomNavigationGraph
import al.bruno.sportify.navigation.bottomNavigationScreens
import al.bruno.sportify.ui.authentication.AuthViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNewEventAction: () -> Unit,
    onEventDetailsAction: () -> Unit
) {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = koinViewModel<AuthViewModel>()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = {
                        authViewModel.logout()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.Logout,
                            contentDescription = "LogOut"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                navController = navController,
                bottomNavigationScreens = bottomNavigationScreens
            )
        }
    ) {
        BottomNavigationGraph(
            navController = navController,
            modifier = Modifier.padding(it),
            onNewEventAction = onNewEventAction,
            onEventDetailsAction = onEventDetailsAction
        )
    }
}