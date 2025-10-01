package pt.iade.ei.greenventos.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.greenventos.R
import java.util.Calendar


@Composable
fun EventListItem(
    title: String,
    date: Calendar,
    room: String,
    rsvp: Int,
    @DrawableRes posterId: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(posterId),
                contentDescription = title,
                modifier = Modifier
                    .height(70.dp)
                    .padding(end = 10.dp)
            )

            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = "${date.get(Calendar.DAY_OF_MONTH)}/${date.get(Calendar.MONTH)} - " +
                            "${date.get(Calendar.HOUR_OF_DAY)}:${date.get(Calendar.MINUTE)} " +
                            " - $room",
                    color = Color.DarkGray,
                    fontSize = 15.sp
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = rsvp.toString(),
                fontSize = 15.sp
            )
            Text(
                text = "RSVP",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EventListItemPreview() {
    EventListItem(
        title = "Tech Club",
        date = Calendar.getInstance(),
        room = "Tech Lab",
        rsvp = 8,
        posterId = R.drawable.green_campus
    )
}

