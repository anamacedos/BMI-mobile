package br.senai.sp.jandira.bmi.screans

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculator
import br.senai.sp.jandira.bmi.model.BMIStatus
import br.senai.sp.jandira.bmi.screans.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable
fun BMIResultScreen(navController: NavHostController?) {


    val context = LocalContext.current
    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val age = sharedUserFile.getInt("user_age", 0)
    val height = sharedUserFile.getInt("user_height", 0).toDouble()
    val weight = sharedUserFile.getInt("user_weight", 0)

    val bmiResult = bmiCalculator(weight, height)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFb9a3e2))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = "Your BMI Result",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 60.dp, start = 24.dp)
            )
            Card (
                modifier = Modifier
                    .weight(6f)
                    .fillMaxWidth(),
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Card (
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 4.dp,
                            color = bmiResult.color
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .size(130.dp),
//                            .align(alignment = Alignment.CenterHorizontally),
                    ){
                        Row (
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = String.format(Locale.getDefault(),
                                    "%.1f",
                                    bmiResult.bmi.second),
                                fontSize = 46.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }

                    Row(){
                        Text(
                            text = bmiResult.bmi.first,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(85.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF9E94CE)

                        ),
//                        RoundedCornerShape(20.dp)

                    ) {
                        Row (
                            modifier = Modifier
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                                
                            ) {
                                Text(
                                    text = "Age",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = age.toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .height(70.dp),
                            )
                            Column (
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Weight",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = weight.toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .height(70.dp)
                            )
                            Column (
                                modifier = Modifier
                                    .weight(1f), 
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "height",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        "%.2f", //antes do ponto qlqr coisa, depois 2 casa de    ponto flutuante
                                        height.div(100)
                                    ),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            }
                        }
                    }
                    //Mostrar o resultado do imc
                    BmiLevel(
                        markColor = colorResource(R.color.light_blue),
                        text1 = stringResource(R.string.under_weight_table),
                        text2 = "< ${numberFormat(18.5)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.UNDERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_green),
                        text1 = stringResource(R.string.normal_weight_table),
                        text2 = "${numberFormat(18.6)} - ${numberFormat(24.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.NORMAL)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.yellow),
                        text1 = stringResource(R.string.over_weight_table),
                        text2 = "${numberFormat(25.0)} - ${numberFormat(29.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.OVERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_orange),
                        text1 = stringResource(R.string.obesity1),
                        text2 = "${numberFormat(30.0)} - ${numberFormat(34.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.OBESITY1)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.dark_orange),
                        text1 = stringResource(R.string.obesity2),
                        text2 = "${numberFormat(35.0)} - ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.OBESITY2)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.red),
                        text1 = stringResource(R.string.obesity3),
                        text2 = "> ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BMIStatus.OBESITY3)
                    )
                    HorizontalDivider()
                    Button(
                        onClick = {
                            navController?.navigate("user_data")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "New Calc"
                        )
                    }
                }
            }

        }
    }


}




@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(navController = null)

}