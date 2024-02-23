package al.bruno.sportify.ui.event

import al.bruno.sportify.model.LeaveTypes
import al.bruno.sportify.ui.home.EventViewModel
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import al.bruno.sportify.R

@Composable
fun AddLeave(
    datePicker: () -> Unit,
    success: () -> Unit,
    navigateUp: () -> Unit,
    eventViewModel: EventViewModel
) {
    eventViewModel.leaveTypes()
    var description by rememberSaveable { mutableStateOf("") }
    var comment by rememberSaveable { mutableStateOf("") }
    var startDate by rememberSaveable { mutableStateOf("") }
    var leaveType by rememberSaveable { mutableStateOf(LeaveTypes(1, "", "")) }

    var showMenu by remember { mutableStateOf( false ) }
    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = { Text(text = stringResource(id = R.string.add_leave)) },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
//        bodyContent = {
//            Column(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                TextField(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    value = description,
//                    onValueChange = {
//                        description = it
//                    },
//                    label = { Text(text = stringResource(id = R.string.description)) }
//                )
//                TextField(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    value = comment,
//                    onValueChange = {
//                        comment = it
//                    },
//                    label = { Text(text = stringResource(id = R.string.comment)) }
//                )
//                TextButton(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    onClick = datePicker
//                ) {
//                    Text(text = leaveViewModel.startDate)
//                }
//                DropdownMenu(
//                    toggle = {
//                        Text(
//                            text = if (leaveViewModel.leaveTypes.isNotEmpty())
//                                leaveViewModel.leaveTypes[selectedIndex].description
//                            else
//                                "Leave Types",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable(onClick = { showMenu = true })
//                        )
//                    },
//                    expanded = showMenu,
//                    onDismissRequest = { showMenu = false },
//                    toggleModifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth(),
//                    dropdownOffset = Position(0.dp, 0.dp),
//                    dropdownModifier = Modifier
//                        .padding(8.dp)
//                        .fillMaxWidth()
//
//                ) {
//                    leaveViewModel.leaveTypes.forEachIndexed { index, type ->
//                        DropdownMenuItem(
//                            onClick = {
//                                showMenu = false
//                                selectedIndex = index
//                                leaveType = leaveViewModel.leaveTypes[index]
//                            }
//                        ) {
//                            Text(
//                                modifier = Modifier
//                                    .padding(8.dp)
//                                    .fillMaxWidth(),
//                                text = type.description
//                            )
//                        }
//                    }
//                }
//
//                Button(
//                    enabled = description.isNotEmpty() && comment.isNotEmpty(),
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .align(Alignment.End),
//                    onClick = {
//                        leaveViewModel.leave(
//                            LeaveDto(
//                                description = description,
//                                comment = comment,
//                                leaveTypes = leaveType,
//                                LocalDateTime.now(),
//                                LocalDateTime.now()
//                            )
//                        )
//                        success.invoke()
//                    }) {
//                    Text(text = stringResource(id = R.string.save))
//                }
//            }
//        }
    ) {
        it.calculateBottomPadding()
    }
}