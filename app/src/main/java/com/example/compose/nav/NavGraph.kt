package com.example.compose

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.compose.Destinations.LeaveDetail
import com.example.compose.Destinations.AddLeave
import com.example.compose.Destinations.SignIn

object Destinations {
    const val Home = "home"
    const val AddLeave = "addLeave"
    const val SignIn = "signIn"
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
    val signIn: () -> Unit = {
        navController.navigate(SignIn)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
//    val openTask: (Int) -> Unit = { taskId ->
//        navController.navigate("$TaskDetail/$taskId")
//    }
//    val addTask: () -> Unit = {
//        navController.navigate(AddTask)
//    }
//    val addProject: () -> Unit = {
//        navController.navigate(AddProject)
//    }
//    val navigateUp: () -> Unit = {
//        navController.popBackStack()
//    }
}