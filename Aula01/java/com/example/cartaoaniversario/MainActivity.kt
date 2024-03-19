package com.example.cartaoaniversario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaoaniversario.ui.theme.CartaoAniversarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoAniversarioTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImagemCartao(
                        mensagem = stringResource(R.string.texto_feliz_aniversario),
                        remetente = stringResource(R.string.texto_assinatura)
                    )
                }
            }
        }
    }
}

@Composable
fun Texto(mensagem: String, remetente: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = mensagem,
            fontSize = 70.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.background(color = Color(0,0,155,75))
        )
        Text(
            text = remetente,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .align(alignment = Alignment.End),
            color = Color.DarkGray
        )
    }
}

@Composable
fun ImagemCartao(mensagem: String, remetente: String, modifier: Modifier = Modifier){
    val imagem = painterResource(R.drawable.androidparty)
    Box (modifier){
        Image(
            painter = imagem,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.75F
        )
        Texto(
            mensagem = mensagem,
            remetente = remetente,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    CartaoAniversarioTheme{
        ImagemCartao(mensagem = stringResource(R.string.texto_feliz_aniversario), remetente = stringResource(R.string.texto_assinatura))
    }
}
