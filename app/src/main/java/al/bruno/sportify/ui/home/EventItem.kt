package al.bruno.sportify.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import al.bruno.sportify.model.Event
import al.bruno.sportify.R
import al.bruno.sportify.common.format

@Composable
fun LeaveItem(event: Event) {
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            LeaveCell(title = stringResource(id = R.string.requested_by), value = event.created.username)
            LeaveCell(title = stringResource(id = R.string.requested_date), value = format(event.dateCreated))
            LeaveCell(title = stringResource(id = R.string.start_date), value = format(event.startDate))
            LeaveCell(title = stringResource(id = R.string.end_date), value = format(event.endDate))
            LeaveCell(title = stringResource(id = R.string.description), value = event.description)
            LeaveCell(title = stringResource(id = R.string.comment), value = event.title)
            LeaveCell(title = stringResource(id = R.string.leave_description), value = event.eventType.description)
            LeaveCell(title = stringResource(id = R.string.leave_type), value = event.eventType.code)
        }
    }
}