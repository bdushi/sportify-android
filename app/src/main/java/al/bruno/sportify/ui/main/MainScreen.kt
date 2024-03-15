package al.bruno.sportify.ui.main

import al.bruno.sportify.navigation.Actions
import al.bruno.sportify.navigation.NavigationScreen
import al.bruno.sportify.ui.event.create.NewEventScreen
import al.bruno.sportify.ui.event.details.EventDetails
import al.bruno.sportify.ui.home.AppScaffold
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBarNavController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.route
    ) {
        composable(NavigationScreen.Home.route) {
            AppScaffold(
                actions.newEvent,
                actions.eventDetails,
                navBarNavController
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


