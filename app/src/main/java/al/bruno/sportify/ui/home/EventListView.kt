package al.bruno.sportify.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import al.bruno.sportify.model.Event

@Composable
fun LeaveListView(event: List<Event>) {
    LazyColumn {
        items(event.size) {
            LeaveItem(event = event[it])
        }
    }
}