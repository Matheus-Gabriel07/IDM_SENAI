package com.example.frasesmotivacionais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frasesmotivacionais.dados.dados
import com.example.frasesmotivacionais.modelo.Motivacional
import com.example.frasesmotivacionais.ui.theme.FrasesMotivacionaisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrasesMotivacionaisTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppMotivacional()
                }
            }
        }
    }
}

@Composable
fun AppMotivacional(){
    ListaMotivacional(
        listaMotivacional = dados().carregarMotivacionais()
    )
}

@Composable
fun ListaMotivacional(listaMotivacional: List<Motivacional>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(listaMotivacional){motivacional ->
            CartaoMotivacional(
                motivacional = motivacional,
                modifier = modifier.padding(8.dp))

        }
    }
}

@Composable
fun CartaoMotivacional(motivacional: Motivacional, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(motivacional.imageResourceId),
                contentDescription = stringResource(motivacional.stringResourceId),
                modifier = modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(motivacional.stringResourceId),
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartaoMotivacionalPreview() {
    CartaoMotivacional(Motivacional(R.string.motivacional1, R.drawable.imagem1))
}