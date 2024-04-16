package com.example.galeria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeria.ui.theme.GaleriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    layoutGaleriaDeFotos()
                }
            }
        }
    }
}

@Composable
fun layoutGaleriaDeFotos(modifier: Modifier = Modifier){
    var valorFoto by remember { mutableStateOf(1)}
    Surface{
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )  {
            Box {
                when (valorFoto) {
                    1 -> ImagemELegenda(
                        drawableResourceId = R.drawable.foto1,
                        contentDescriptionResourceId = R.string.content_foo_1_paisagem,
                        legendaLabelResourceId = R.string.foto_1_paisagem_preto_e_branco,
                        anoLabelResourceId = R.string.foto_1
                    )

                    2 -> ImagemELegenda(
                        drawableResourceId = R.drawable.foto2,
                        contentDescriptionResourceId = R.string.content_foo_2_cidade,
                        legendaLabelResourceId = R.string.foto_2_cidade_preto_e_branco,
                        anoLabelResourceId = R.string.foto_2
                    )

                    3 -> ImagemELegenda(
                        drawableResourceId = R.drawable.foto3,
                        contentDescriptionResourceId = R.string.content_foo_3_praia,
                        legendaLabelResourceId = R.string.foto_3_menina_na_praia,
                        anoLabelResourceId = R.string.foto_3
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espacador)))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Button(
                        onClick = {
                            if (valorFoto > 1) {
                                valorFoto--
                            } else {
                                valorFoto = 3
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.Gray)
                    ) {
                        Text(text = "Voltar")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (valorFoto < 3) {
                                valorFoto++
                            } else {
                                valorFoto = 1
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.Gray)
                    ) {
                        Text(text = "Avançar")
                    }
                }
            }
        }
    }
}

@Composable
fun ImagemELegenda(
    modifier: Modifier = Modifier,
    drawableResourceId : Int,
    contentDescriptionResourceId : Int,
    legendaLabelResourceId: Int,
    anoLabelResourceId : Int
) {
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId).toString(),
                modifier = modifier
                    .height(320.dp)
                    .padding(4.dp)
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .border(8.dp, Color.Gray),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espacador)))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ){
                Text(
                    text = stringResource(legendaLabelResourceId),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier.padding(16.dp)
                )
                Text(
                    text = stringResource(anoLabelResourceId),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaleriaTheme {
        layoutGaleriaDeFotos()
    }
}