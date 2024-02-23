package al.bruno.sportify.ui.signup

import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun SignUp(
    navigateUp: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(elevation = 0.dp, title = { Text(text = "New Account") }, navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = null)
            }
        }, actions = {
            Button(onClick = {
                navigateUp()
            }) {
                Text("Save")
            }
        })
    }) {
        it.calculateBottomPadding()
        Text(text = "Test")
    }
}