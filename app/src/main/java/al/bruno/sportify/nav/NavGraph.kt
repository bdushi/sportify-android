package al.bruno.sportify.nav

import androidx.navigation.NavHostController
import al.bruno.sportify.nav.Destinations.LeaveDetail
import al.bruno.sportify.nav.Destinations.AddLeave

object Destinations {
    const val Home = "home"
    const val AddLeave = "addLeave"
    const val SignIn = "signIn"
    const val SignUp = "signUp"
    const val LeaveDetail = "leaveDetail"

    object LeaveDetailArgs {
        const val LeaveId = "leaveId"
    }
}

class Actions(navController: NavHostController) {
    val openLeave: (Int) -> Unit = { taskId ->
        navController.navigate("$LeaveDetail/$taskId")
    }
    val addLeave: () -> Unit = {
        navController.navigate(AddLeave)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}