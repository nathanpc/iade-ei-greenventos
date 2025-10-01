package pt.iade.ei.greenventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.greenventos.ui.components.EventListItem
import pt.iade.ei.greenventos.ui.theme.GreenventosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenventosTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GreenventosTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Greenventos")
            for (i in 1..5) {
                EventListItem()
            }
        }
    }
}