package br.senai.sp.jandira.bmi.screans

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BMIResultScreen(navController: NavHostController?) {

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
                            color = Color(0xFF43A047)
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
                                text = "30,6",
                                fontSize = 46.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }

                    Row(){
                        Text(
                            text = "You have class I Obesity",
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
                                    text = "50",
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
                                    text = "97 Kg",
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
                                    text = "High",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "178 cm",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Green)
                            .height(300.dp)
                    ){}
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