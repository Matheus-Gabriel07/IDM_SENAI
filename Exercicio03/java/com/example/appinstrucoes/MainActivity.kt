package com.example.appinstrucoes

import android.graphics.fonts.FontStyle
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appinstrucoes.ui.theme.AppInstrucoesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppInstrucoesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main(Modifier)
                }
            }
        }
    }
}

@Composable
fun Barra(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .background(Color(105, 205, 215))
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Gravação",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            letterSpacing = 5.sp
        )
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    var valorPagina by remember { mutableStateOf(1) }

    val insereImagem = when (valorPagina) {
        1 -> R.drawable.play
        2 -> R.drawable.pause
        3 -> R.drawable.editar
        4 -> R.drawable.libray
        else -> R.drawable.lixo
    }
    val insereTexto = when (valorPagina) {
        1 -> "Gravar video"
        2 -> "Pausar gravação"
        3 -> "Editar video"
        4 -> "Ver na biblioteca"
        else -> "Jogar fora gravação"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(210,210,210)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Barra()
        Spacer(modifier = modifier.height(24.dp))
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    if (valorPagina < 5) {
                        valorPagina += 1
                    } else {
                        valorPagina = 1
                    }
                },
                modifier = modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(2.dp)
                    .background(Color(105, 205, 215))
                    .border(2.dp, Color(105, 205, 215), shape = RoundedCornerShape(4.dp)),
            ) {
                Image(
                    painter = painterResource(insereImagem),
                    contentDescription = insereTexto
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = insereTexto,
                fontSize = 18.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppInstrucoes(){
    Main(Modifier)
}