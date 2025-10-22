package pt.iade.ei.greenventos

import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.runBlocking
import pt.iade.ei.greenventos.models.EventItem
import pt.iade.ei.greenventos.models.hoursToMinutes
import pt.iade.ei.greenventos.ui.components.EventListItem
import pt.iade.ei.greenventos.ui.theme.GreenventosTheme
import java.util.Calendar
import kotlin.Int

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenventosTheme {
                val eventList = remember { mutableStateListOf<EventItem>() }

                "http://10.0.2.2:5000/events".httpGet().response {
                        request, response, result ->
                    // Get JSON string from response body.
                    val json = String(response.data)
                    Log.i("OTHER", json)

                    // Setup JSON parser from Google and parse the JSON string.
                    val builder = GsonBuilder().create()
                    val obj: JsonObject = builder.fromJson(json, JsonObject().javaClass)

                    // Get array of events.
                    val arr: JsonArray = obj.get("events") as JsonArray

                    // Get list of events from JSON array.
                    for (eventElement in arr) {
                        val event: JsonObject = eventElement as JsonObject
                        eventList.add(EventItem(
                            id = event.get("id").asInt,
                            title = event.get("title").asString,
                            date = Calendar.getInstance(),
                            room = event.get("room").asString,
                            durationMinutes = event.get("durationMinutes").asInt,
                            rsvp = event.get("rsvp").asInt,
                            description = event.get("description").asString
                        ))
                    }
                }

                MainView(eventList)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    eventsList: List<EventItem>
) {
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            for (event in eventsList) {
                EventListItem(event)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GreenventosTheme {
        MainView(
            eventsList = listOf(
                EventItem(
                    id = 123,
                    title = "Tech Club",
                    date = Calendar.getInstance(),
                    room = "Tech Lab",
                    durationMinutes = hoursToMinutes(4),
                    rsvp = 8
                ),
                EventItem(
                    id = 123,
                    title = "Tech Club 2",
                    date = Calendar.getInstance(),
                    room = "Tech Lab",
                    durationMinutes = hoursToMinutes(4),
                    rsvp = 8
                ),
                EventItem(
                    id = 123,
                    title = "Tech Club 3",
                    date = Calendar.getInstance(),
                    room = "Tech Lab",
                    durationMinutes = hoursToMinutes(4),
                    rsvp = 8
                )
            )
        )
    }
}