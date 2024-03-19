package com.example.cartao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartao.ui.theme.CartaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartaoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxMain()
                }
            }
        }
    }
}

@Composable
fun BoxImagem(modifier: Modifier = Modifier) {
    val imagemPerfil = painterResource(R.drawable.photo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Image (
            painter = imagemPerfil,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )
        Text(
            text = "Matheus",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun BoxInformacoes(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
    ) {
        Text (
            text = "(11) 957622147",
            fontSize = 14.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text (
            text = "Matheus-Gabriel07",
            fontSize = 14.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text (
            text = "math.gsilva07@gmail.com",
            fontSize = 14.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BoxMain(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .background(Color(12, 12, 12, 55))
    ) {
        BoxImagem()
        BoxInformacoes()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartaoTheme {
        BoxMain()
    }
}