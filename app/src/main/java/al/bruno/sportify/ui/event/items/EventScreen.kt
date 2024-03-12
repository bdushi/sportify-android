package al.bruno.sportify.ui.event.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import org.koin.androidx.compose.koinViewModel

@Composable
fun EventScreen(
    onEventDetailsAction: () -> Unit,
) {
    val eventViewModel: EventViewModel = koinViewModel()
    val leavesItems = eventViewModel.pagedLeaves.collectAsLazyPagingItems()
    LazyColumn {
        items(leavesItems.itemCount) { item ->
            leavesItems[item]?.let { EventItems(event = it, onEventDetailsAction = onEventDetailsAction) }
        }
        leavesItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView() }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }

                loadState.refresh is LoadState.Error -> {
                    val e = leavesItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(message = e.error.localizedMessage!!, onClickRetry = { retry() })
                    }
                }

                loadState.append is LoadState.Error -> {
                    val e = leavesItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(message = e.error.localizedMessage!!, onClickRetry = { retry() })
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(message: String?, onClickRetry: () -> Unit) {
    Snackbar(action = {
        TextButton(onClick = onClickRetry) {
            Text("Refresh", color = Color.Red)
        }
    }) {
        Text(text = message.toString())
    }
}