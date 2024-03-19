package com.example.artigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    ArtigoCompleto("Apple pode lançar novos AirPods junto com iPhone 16",
                        "Ainda não há como prever quando os novos modelos " +
                                "chegarão ao Brasil. Com atualização de design, " +
                                "novas tecnologias e ajustes de áudio, preço pode " +
                                "aumentar consideravelmente.",
                        "A Apple estaria trabalhando em dois novos AirPods para " +
                                "anunciar na mesma época do iPhone 16, provavelmente em " +
                                "setembro. A informação é do analista Mark Gurman, repórter " +
                                "do site Bloomberg especialista em produtos da maçã, e foi publicada" +
                                " no domingo (17). De acordo com a coluna, os modelos inéditos " +
                                "devem chegar para substituir a segunda e terceira gerações do acessório" +
                                " e podem entrar em produção em massa já em maio deste ano.\n"
                    )
                }
            }
        }
    }
}

@Composable
fun Texto(titulo: String, resumo : String, artigo : String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    )  {
        Text(
            text = titulo,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = resumo,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
        Text(
            text = artigo,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            )
        )
    }
}

@Composable
fun ArtigoCompleto(titulo: String, resumo : String, artigo : String, modifier: Modifier = Modifier){
    val imagem = painterResource(R.drawable.noticia)
    Box(modifier) {
        Image(
            painter = imagem,
            contentDescription = null,
            modifier = Modifier.height(100.dp).fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Texto(
            titulo = titulo,
            resumo = resumo,
            artigo = artigo,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtigoTheme {
        ArtigoCompleto("Apple pode lançar novos AirPods junto com iPhone 16",
            "Ainda não há como prever quando os novos modelos " +
                    "chegarão ao Brasil. Com atualização de design, " +
                    "novas tecnologias e ajustes de áudio, preço pode " +
                    "aumentar consideravelmente.",
            "A Apple estaria trabalhando em dois novos AirPods para " +
                    "anunciar na mesma época do iPhone 16, provavelmente em " +
                    "setembro. A informação é do analista Mark Gurman, repórter " +
                    "do site Bloomberg especialista em produtos da maçã, e foi publicada" +
                    " no domingo (17). De acordo com a coluna, os modelos inéditos " +
                    "devem chegar para substituir a segunda e terceira gerações do acessório" +
                    " e podem entrar em produção em massa já em maio deste ano.\n"
        )
    }
}