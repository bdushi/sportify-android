package al.bruno.sportify.navigation

import androidx.annotation.StringRes
import al.bruno.sportify.R

sealed class BottomNavigationScreen(val route: String, @StringRes val resourceId: Int, val icon: Int) {
    data object Home : BottomNavigationScreen("Home", R.string.home, R.drawable.ic_round_home_24)
    data object Favourite : BottomNavigationScreen("Favourite", R.string.favourite, R.drawable.ic_round_favorite_24)
    data object Event : BottomNavigationScreen("Event", R.string.event, R.drawable.ic_outline_add_box_24)
    data object Notification : BottomNavigationScreen("Notification", R.string.notification, R.drawable.ic_round_notifications_24)
    data object Profile : BottomNavigationScreen("Profile", R.string.profile, R.drawable.ic_round_account_circle_24)
}

val bottomNavigationScreens = listOf(
    BottomNavigationScreen.Home,
    BottomNavigationScreen.Favourite,
    BottomNavigationScreen.Event,
    BottomNavigationScreen.Notification,
    BottomNavigationScreen.Profile,
)