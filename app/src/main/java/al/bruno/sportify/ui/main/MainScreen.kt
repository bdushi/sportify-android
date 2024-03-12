package al.bruno.sportify.ui.main

import al.bruno.sportify.navigation.Actions
import al.bruno.sportify.navigation.NavigationScreen
import al.bruno.sportify.ui.authentication.AuthViewModel
import al.bruno.sportify.ui.event.create.NewEventScreen
import al.bruno.sportify.ui.event.details.EventDetails
import al.bruno.sportify.ui.event.items.EventViewModel
import al.bruno.sportify.ui.home.HomeScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Main.route,
        modifier = Modifier.padding(),
    ) {
        composable(NavigationScreen.Main.route) {
            HomeScreen(
                actions.newEvent,
                actions.eventDetails
            )
        }
        composable(NavigationScreen.NewEvent.route) {
            NewEventScreen(actions.navigateUp)
        }
        composable(NavigationScreen.EventDetails.route) {
            EventDetails(actions.navigateUp)
        }
    }
}


