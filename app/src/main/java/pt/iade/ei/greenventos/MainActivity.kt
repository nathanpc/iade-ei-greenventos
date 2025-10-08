package pt.iade.ei.greenventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.greenventos.models.EventItem
import pt.iade.ei.greenventos.models.hoursToMinutes
import pt.iade.ei.greenventos.ui.components.EventListItem
import pt.iade.ei.greenventos.ui.theme.GreenventosTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenventosTheme {
                MainView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Greenventos")
                }
            )
        }
    ) { innerPadding ->
        val item = EventItem(
            id = 123,
            title = "Tech Club",
            date = Calendar.getInstance(),
            room = "Tech Lab",
            durationMinutes = hoursToMinutes(4),
            rsvp = 8
        )

        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            EventListItem(item)
            item.title = "outro evento"
            EventListItem(item)

            for (i in 1..5) {
                EventListItem(
                    title = "Tech Club $i",
                    date = Calendar.getInstance(),
                    room = "Tech Lab",
                    rsvp = 8 + i,
                    posterId = R.drawable.green_campus
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GreenventosTheme {
        MainView()
    }
}