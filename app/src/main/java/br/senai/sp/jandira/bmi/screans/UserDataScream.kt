package br.senai.sp.jandira.bmi.screans

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScream(){

    var ageState = remember{
        mutableStateOf("")
    }
    var weightState = remember {
        mutableStateOf("")
    }
    var heightState = remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFb9a3e2))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                stringResource(R.string.Hi) + "!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 32.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                    //no space tem como colocar o bettwen e o around tambem


                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column (
                            modifier = Modifier
                                .weight(1f), //usa o peso para determinar quanto vai usar do espaço, como cada um pesa 1, cada um vai ocupar metade

                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF793FFA),
                                            Color(0xFFA696E0)
                                        )
                                    )
                                ),
                                elevation = CardDefaults.cardElevation(2.dp)

                            ){
                                Image(
                                    //quando é image é image vector, porem qnd é png é painter
                                    painter = painterResource(R.drawable.male),
                                    contentDescription = ""
                                )

                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.male)
                                )
                            }
                        }
                        Column(
                        modifier = Modifier
                            .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF793FFA),
                                            Color(0xFFA696E0)
                                        )
                                    )
                                ),
                                elevation = CardDefaults.cardElevation(2.dp)

                            ){
                                Image(
                                    //quando é image é image vector, porem qnd é png é painter
                                    //flaticon e iconfinder para achar icons
                                    painter = painterResource(R.drawable.female),
                                    contentDescription = ""
                                )

                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.female)
                                )
                            }
                        }

                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ){
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.Age))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xffa6750a4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF5E35B1),
                                cursorColor = Color(0xFF5E35B1),
                                focusedLabelColor = Color(0xFF5E35B1),
                                unfocusedBorderColor = Color(0xFFBEA6F3)
                            ),
                            textStyle = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.Weight))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xffa6750a4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF5E35B1),
                                cursorColor = Color(0xFF5E35B1),
                                focusedLabelColor = Color(0xFF5E35B1),
                                unfocusedBorderColor = Color(0xFFBEA6F3)
                            ),
                            textStyle = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.Height))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(0xffa6750a4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF5E35B1),
                                cursorColor = Color(0xFF5E35B1),
                                focusedLabelColor = Color(0xFF5E35B1),
                                unfocusedBorderColor = Color(0xFFBEA6F3)
                            ),
                            textStyle = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(48.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xffaaaaaa)
//                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 18.sp,

                        )
                    }
                }

            }
        }
    }

    }

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreamPreview() {
    UserDataScream()

}