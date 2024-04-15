/* Exemplo de aula - 09/04
*  @author Matheus Gabriel
*/

package com.example.calculadoradegorjetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoradegorjetas.ui.theme.CalculadoraDeGorjetasTheme
import java.text.NumberFormat
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraDeGorjetasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    LayoutCalculadora()
                }
            }
        }
    }
}

@Composable
fun LayoutCalculadora(){
    var quantiaEntrada by remember {mutableStateOf("" )}
    var porcentagemEntrada by remember {mutableStateOf("" )}
    var arredondamento by remember { mutableStateOf(false) }
    val quantia = quantiaEntrada.toDoubleOrNull() ?: 0.0
    val porcentagem = porcentagemEntrada.toDoubleOrNull() ?: 0.0
    val gorjeta = calcularGorjeta(quantia, porcentagem,arredondamento)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calcular_gorjeta),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            rotulo = R.string.total_do_pedido,
            keyboradOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            valor = quantiaEntrada,
            onValorAlterado = {quantiaEntrada = it},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        EditNumberField(
            rotulo = R.string.como_foi_o_atendimento,
            keyboradOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            valor = porcentagemEntrada,
            onValorAlterado = { porcentagemEntrada = it},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        LinhaArredGorjeta(
            arredondamento = arredondamento,
            onArredondamentoALterado = {arredondamento = it}
        )
        Text(
            text = stringResource(R.string.valor_gorjeta, gorjeta),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    @StringRes rotulo: Int,
    keyboradOptions: KeyboardOptions,
    valor: String,
    onValorAlterado: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = valor,
        onValueChange = onValorAlterado,
        singleLine = true,
        modifier = modifier,
        label = { Text(stringResource(rotulo))},
        keyboardOptions = keyboradOptions
    )
}

@Composable
fun LinhaArredGorjeta(
    arredondamento : Boolean,
    onArredondamentoALterado: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.arredondar_gorjeta))
        Switch(
            checked = arredondamento,
            onCheckedChange = onArredondamentoALterado,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

private fun calcularGorjeta(quantia : Double, porcentagemGorjeta : Double = 10.0, arredondamento: Boolean) : String{
    var gorjeta = (porcentagemGorjeta / 100) * quantia
    if(arredondamento){
        gorjeta = kotlin.math.round(gorjeta)
    }
    return NumberFormat.getCurrencyInstance().format(gorjeta)
}

@Preview(showBackground = true)
@Composable
fun LayoutCalculadoraPreview() {
    CalculadoraDeGorjetasTheme {
        LayoutCalculadora()
    }
}