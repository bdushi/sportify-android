package al.bruno.sportify.ui.event.create

import al.bruno.foundation.AutoCompleteTextView
import al.bruno.foundation.NewEventTextField
import al.bruno.sportify.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Title
import androidx.compose.material.icons.rounded.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewEventScreen(
    navigateUp: () -> Unit,
    newEventViewModel: NewEventViewModel = koinViewModel()
) {

    var description by rememberSaveable { mutableStateOf("") }
    var title by rememberSaveable { mutableStateOf("") }
    var comment by rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = { Text(text = stringResource(id = R.string.new_event)) },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "New Event Back Button"
                        )
                    }
                }
            )
        }
    ) {
        it.calculateBottomPadding()
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            NewEventTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.9f),
                value = title,
                onValueChange = { value ->
                    title = value
                },
                label = { Text(text = stringResource(id = R.string.title)) },
                contentDescription = stringResource(id = R.string.title),
                imageVector = Icons.Filled.Title
            )

            NewEventTextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.9f),
                value = description,
                onValueChange = { value ->
                    description = value
                },
                label = { Text(text = stringResource(id = R.string.description)) },
                contentDescription = stringResource(id = R.string.description),
                imageVector = Icons.Filled.TextFields
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                value = comment,
                onValueChange = {
                    comment = it
                },
                label = { Text(text = stringResource(id = R.string.comment)) }
            )
//            TextButton(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .fillMaxWidth(),
//                onClick = datePicker
//            ) {
//                Text(text = leaveViewModel.startDate)
//            }
        }
    }
}
//    var startDate by rememberSaveable { mutableStateOf("") }
//    var leaveType by rememberSaveable { mutableStateOf(EventType("test", "Test", "Test", "Test", true, OffsetDateTime.now(), OffsetDateTime.now())) }
//
//    var showMenu by remember { mutableStateOf( false ) }
//    var selectedIndex by remember { mutableIntStateOf(0) }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                elevation = 0.dp,
//                title = { Text(text = stringResource(id = R.string.add_leave)) },
//                navigationIcon = {
//                    IconButton(onClick = navigateUp) {
//                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
//                    }
//                }
//            )
//        },
////        bodyContent = {
////                DropdownMenu(
////                    toggle = {
////                        Text(
////                            text = if (leaveViewModel.leaveTypes.isNotEmpty())
////                                leaveViewModel.leaveTypes[selectedIndex].description
////                            else
////                                "Leave Types",
////                            modifier = Modifier
////                                .fillMaxWidth()
////                                .clickable(onClick = { showMenu = true })
////                        )
////                    },
////                    expanded = showMenu,
////                    onDismissRequest = { showMenu = false },
////                    toggleModifier = Modifier
////                        .padding(8.dp)
////                        .fillMaxWidth(),
////                    dropdownOffset = Position(0.dp, 0.dp),
////                    dropdownModifier = Modifier
////                        .padding(8.dp)
////                        .fillMaxWidth()
////
////                ) {
////                    leaveViewModel.leaveTypes.forEachIndexed { index, type ->
////                        DropdownMenuItem(
////                            onClick = {
////                                showMenu = false
////                                selectedIndex = index
////                                leaveType = leaveViewModel.leaveTypes[index]
////                            }
////                        ) {
////                            Text(
////                                modifier = Modifier
////                                    .padding(8.dp)
////                                    .fillMaxWidth(),
////                                text = type.description
////                            )
////                        }
////                    }
////                }
////
////                Button(
////                    enabled = description.isNotEmpty() && comment.isNotEmpty(),
////                    modifier = Modifier
////                        .padding(8.dp)
////                        .align(Alignment.End),
////                    onClick = {
////                        leaveViewModel.leave(
////                            LeaveDto(
////                                description = description,
////                                comment = comment,
////                                leaveTypes = leaveType,
////                                LocalDateTime.now(),
////                                LocalDateTime.now()
////                            )
////                        )
////                        success.invoke()
////                    }) {
////                    Text(text = stringResource(id = R.string.save))
////                }
////            }
////        }
//    ) {
//        it.calculateBottomPadding()
//    }
//}

@Preview
@Composable
fun createNewEventPreview() {
    NewEventScreen(navigateUp = {

    })
//    val predicate = arrayListOf("KitKat", "Kinder")
//    AutoCompleteTextView(
//        modifier = Modifier.fillMaxWidth(),
//        query = "",
//        queryLabel = stringResource(id = R.string.search_label),
//        onQueryChanged = { updatedAddress ->
//
////            locationItem.streetAddress = updatedAddress
//            //Todo: call the view model method to update addressPlaceItemPredictions
//        },
//        predictions = predicate,
//        onClearClick = {
////            locationItem.streetAddress = ""
//            //Todo: call the view model method to clear the predictions
//
//        },
//        onDoneActionClick = {
////            newLocationUIAction(NewLocationUIAction.OnLocationAutoCompleteDone)
//        },
//        onItemClick = { placeItem ->
//
//            //Todo: call the view model method to update the UI with the selection
//
//        }
//    ) {
//        //Define how the items need to be displayed
//        Text(it, fontSize = 14.sp)
//    }
}