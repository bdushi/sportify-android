package al.bruno.sportify.ui.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import al.bruno.sportify.ui.signin.AuthViewModel

@Composable
fun Home(
    addLeave: () -> Unit,
    eventViewModel: EventViewModel,
    authViewModel: AuthViewModel
) {
    eventViewModel.leave()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Leave") },
                actions = {
                    IconButton(onClick = {
                        authViewModel.logout()
                    }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_logout)
//                        )
                    }
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Rounded.Add, contentDescription = null) },
                onClick = addLeave
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true,
    ) {
        it.calculateBottomPadding()
        LeavePagingListView(eventViewModel.pagedLeaves)
    }
}