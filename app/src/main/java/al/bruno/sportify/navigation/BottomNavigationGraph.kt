package al.bruno.sportify.navigation


import al.bruno.sportify.ui.event.items.EventScreen
import al.bruno.sportify.ui.favourite.FavouriteScreen
import al.bruno.sportify.ui.notification.NotificationScreen
import al.bruno.sportify.ui.profile.ProfileScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    onNewEventAction: () -> Unit,
    onEventDetailsAction: () -> Unit,
    modifier: Modifier
) {
    NavHost(navController, startDestination = BottomNavigationScreen.Home.route, modifier) {
        composable(BottomNavigationScreen.Home.route) {
            EventScreen(onEventDetailsAction)
        }
        composable(BottomNavigationScreen.Event.route) {
            onNewEventAction.invoke()
        }
        composable(BottomNavigationScreen.Favourite.route) {
            FavouriteScreen()
        }
        composable(BottomNavigationScreen.Notification.route) {
            NotificationScreen()
        }
        composable(BottomNavigationScreen.Profile.route) {
            ProfileScreen()
        }
    }
}