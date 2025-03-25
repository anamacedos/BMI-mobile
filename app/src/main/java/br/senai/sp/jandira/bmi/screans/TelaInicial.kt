package br.senai.sp.jandira.bmi.screans

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun TelaInicial(navController: NavHostController?) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }
    var errorMessageState = remember {
        mutableStateOf("")
    }
    var context = LocalContext.current

    //


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF8C69D2),
                        Color(0xFFFFFFFF)
                    )
                )
            ), //antes de todas as cores tem que colocar 0xff
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Olá Mundo!"
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagem_fitness),
                contentDescription = stringResource(R.string.logo_description),
                modifier = Modifier
                    .padding(top = 35.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 37.sp,//sp é necessario import
                color = Color.White
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ) //forma de cantos arredondados
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),

                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier

                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {
                                nomeState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            label = {
                                Text(text = stringResource(R.string.your_name_here))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = ""
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text, //escolhando qual tipo de teclado vai abrir
                                capitalization = KeyboardCapitalization.Words//para o teclado ja aparecer em maiuscuki
                            ),
                            isError = isErrorState.value,
                            supportingText = {
                                Text(
                                    text = errorMessageState.value,
                                    color = Color.Red
                                )
                            }

                        )
                    }

                    Button(
                        onClick = {
                            if (nomeState.value.length < 3){
                                isErrorState.value = true
                                errorMessageState.value = context.getString(R.string.suporte_1)
                            }else{
                                //Criar um shared preference (criar o acesso a um arquivo shared preference
                                val sharedNome = context
                                    .getSharedPreferences("usuario", Context.MODE_PRIVATE)
                                //Criar uma variável para editar o arquivo que acabamos de criar ou abrir
                                var editor = sharedNome.edit()
                                editor.putString("user_name", nomeState.value.trim())
                                editor.apply() //como se fosse clicar no botão de salvar

                                navController?.navigate("user_data")
                            }

                        },
                        modifier = Modifier
                    ) {
                        Text(
                            text = stringResource(R.string.next)
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = ""
                        )
                    }
                }

            }

        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaInicial(null)

}