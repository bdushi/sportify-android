package al.bruno.sportify.navigation


import al.bruno.sportify.ui.event.items.EventScreen
import al.bruno.sportify.ui.favourite.FavouriteScreen
import al.bruno.sportify.ui.notification.NotificationScreen
import al.bruno.sportify.ui.profile.ProfileScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    onEventDetailsAction: () -> Unit,
    modifier: Modifier
) {
    NavHost(navController, startDestination = BottomNavigationScreen.Item.route, modifier) {
        composable(BottomNavigationScreen.Item.route) {
            EventScreen(onEventDetailsAction)
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