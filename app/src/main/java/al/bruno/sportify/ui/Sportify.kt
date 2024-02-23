package al.bruno.sportify.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import al.bruno.sportify.nav.Actions
import al.bruno.sportify.nav.Destinations
import al.bruno.sportify.ui.event.AddLeave
import al.bruno.sportify.ui.home.Home
import al.bruno.sportify.ui.home.EventViewModel
import al.bruno.sportify.ui.signin.AuthViewModel

@Composable
fun AnnualLeave(

    datePicker: () -> Unit,
    eventViewModel: EventViewModel,
    authViewModel: AuthViewModel
) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    MaterialTheme {
        NavHost(navController = navController, startDestination = Destinations.Home) {
            composable(Destinations.Home) {
                Home(
                    eventViewModel = eventViewModel,
                    authViewModel = authViewModel,
                    addLeave = actions.addLeave
                )
            }
            composable(Destinations.AddLeave) {
                AddLeave(
                    datePicker = datePicker,
                    success = actions.navigateUp,
                    navigateUp = actions.navigateUp,
                    eventViewModel = eventViewModel
                )
            }
        }
    }
}