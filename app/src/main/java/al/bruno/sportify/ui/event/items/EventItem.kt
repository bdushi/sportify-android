package al.bruno.sportify.ui.event.items

import al.bruno.sportify.model.Event
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EventItems(
    event: Event,
    onEventDetailsAction: () -> Unit
) {
    Card(
        onClick = {
            onEventDetailsAction.invoke()
        },
        modifier = Modifier
            .padding(4.dp),
        shape = CardDefaults.outlinedShape
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
        ) {
            GlideImage(
                model = "https://source.unsplash.com/random",
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(text = event.title, fontSize = 24.sp, fontFamily = FontFamily.SansSerif)
                Text(text = event.description)
            }
        }
    }
}