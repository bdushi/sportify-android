package al.bruno.sportify.navigation

import al.bruno.sportify.R
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    data object Item : BottomNavigationScreen("Home", R.string.item, Icons.Filled.Home)
    data object Favourite : BottomNavigationScreen("Favourite", R.string.favourite, Icons.Filled.Favorite)
    data object Event : BottomNavigationScreen("Event", R.string.event, Icons.Outlined.AddBox)
    data object Notification : BottomNavigationScreen("Notification", R.string.notification, Icons.Filled.Notifications)
    data object Profile : BottomNavigationScreen("Profile", R.string.profile, Icons.Filled.AccountCircle)
}

val bottomNavigationScreens = listOf(
    BottomNavigationScreen.Item,
    BottomNavigationScreen.Favourite,
    BottomNavigationScreen.Event,
    BottomNavigationScreen.Notification,
    BottomNavigationScreen.Profile,
)