package al.bruno.sportify.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import al.bruno.sportify.model.Leave

@Composable
fun LeaveListView(leave: List<Leave>) {
    LazyColumn {
        items(leave.size) {
            LeaveItem(leave = leave[it])
        }
    }
}