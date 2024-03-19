package com.example.artigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artigo.ui.theme.ArtigoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtigoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComporArtigo()
                }
            }
        }
    }
}

@Composable
fun ComporArtigo(){
    CartaoArtigo(
        titulo = stringResource(R.string.titulo_artigo),
        descricao = stringResource(R.string.descricao_artigo),
        corpo = stringResource(R.string.corpo_artigo),
        imagem = painterResource(R.drawable.imagem_artigo)
    )
}

@Composable
private fun CartaoArtigo(
    titulo: String,
    descricao: String,
    corpo: String,
    imagem: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier){
        Image(
            painter = imagem,
            contentDescription = null,
            modifier = Modifier.height(100.dp).fillMaxWidth()
        )
        Text(
            text = titulo,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = descricao,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
        Text(
            text = corpo,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtigoTheme {
        ComporArtigo()
    }
}