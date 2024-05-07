package com.example.listadecursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listadecursos.data.Data
import com.example.listadecursos.model.Cursos
import com.example.listadecursos.ui.theme.ListaDeCursosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeCursosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppCursos()
                }
            }
        }
    }
}

@Composable
fun CartaoCurso(curso : Cursos, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(Color(245, 236, 241, 1))
            .width(180.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(curso.imageResourceId),
                contentDescription = stringResource(curso.stringNomeResourceId),
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = stringResource(curso.stringNomeResourceId),
                    modifier = modifier
                        .padding(
                            top = 8.dp,
                        ),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left
                )
                Text(
                    text = curso.stringCodigoResourceId.toString(),
                    modifier = modifier
                        .padding(
                            bottom = 8.dp
                        ),
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Left
                )
            }
            Image(
                painter = painterResource(R.drawable.chapeu_de_graduacao),
                contentDescription = null,
                modifier = modifier
                    .align(AbsoluteAlignment.Right),
            )
        }
    }
}

@Composable
fun GradeCursos(listaCursos: List<Cursos>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(listaCursos) { curso ->
            CartaoCurso(
                curso = curso,
                modifier = modifier.padding(4.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCursos(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    titleContentColor = MaterialTheme.colorScheme.error,
                ),
                title = {
                    Text("Cursos")
                }
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
        }
        GradeCursos(
            Data().carregarGradeCursos(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListaDeCursosTheme {
        CartaoCurso(curso = Cursos(R.drawable.tecnologia, R.string.tecnologia, 123))
    }
}