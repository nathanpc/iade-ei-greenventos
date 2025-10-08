package pt.iade.ei.greenventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.greenventos.models.EventItem
import pt.iade.ei.greenventos.models.hoursToMinutes
import pt.iade.ei.greenventos.ui.components.EventListItem
import pt.iade.ei.greenventos.ui.theme.GreenventosTheme
import java.util.Calendar

class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreenventosTheme {
                DetailView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView() {
    val item = EventItem(
        id = 123,
        title = "Tech Club",
        date = Calendar.getInstance(),
        room = "Tech Lab",
        durationMinutes = hoursToMinutes(4),
        rsvp = 8,
        description = """
            Olá! Você acaba de chegar ao Tech Club! Este é um grupo de professores e alunos que se reunem quase todas as sextas das 9h às 14h no Tech Lab, especificamente no Laboratório de Computação Física.

            A ideia e o principal objetivo por trás desta iniciativa é a criação de uma comunidade tecnológica no IADE. Neste horário poderá partilhar conhecimento, aprender coisas novas, montar computadores ou apenas reparar algo que tenha avariado.

            No Tech Club só há uma regra: Não se pode falar sobre trabalhos de UCs.

            Este espaço é dedicado a projetos pessoais e partilha de conhecimento!
        """.trimIndent()
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back)
                            )
                        }

                        Text(
                            text = item.title,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            // Poster image.
            Image(
                painter = painterResource(R.drawable.green_campus),
                contentDescription = "Event poster",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.height(50.dp)
                ) {
                    val text = stringResource(R.string.add_calendar)
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = text
                        )

                        Text(
                            text = text,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                }
            }

            // Description area.
            Card (
                modifier = Modifier.padding(horizontal = 10.dp),
                onClick = {}
            ) {
                Text(item.description, modifier = Modifier.padding(15.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailViewPreview() {
    GreenventosTheme {
        DetailView()
    }
}