package al.bruno.sportify.navigation

import al.bruno.sportify.R
import androidx.annotation.StringRes
import androidx.navigation.NavHostController

sealed class NavigationScreen(val route: String, @StringRes val resourceId: Int) {
    data object Main : NavigationScreen("Main", R.string.home)
    data object NewEvent : NavigationScreen("NewEvent", R.string.event)
    data object EventDetails : NavigationScreen("EventDetails", R.string.event)
    object NewEventUserIdArgs {
        const val ID = "userid"
    }
}

class Actions(navController: NavHostController) {
    val newEvent: () -> Unit = {
        navController.navigate(NavigationScreen.NewEvent.route) {
            popUpTo(NavigationScreen.Main.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val eventDetails: () -> Unit = {
        navController.navigate(NavigationScreen.EventDetails.route) {
            popUpTo(NavigationScreen.Main.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}

