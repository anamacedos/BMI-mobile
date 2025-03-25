package br.senai.sp.jandira.bmi.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.BMIStatus
import br.senai.sp.jandira.bmi.model.Bmi
import kotlin.math.pow

@Composable
fun bmiCalculator(weight: Int, height: Double): Bmi{

    val bmi = weight / height.pow(2)

    when{
        bmi < 18.5 ->
            return Bmi(
                bmi = Pair("", bmi),
                bmiStatus = BMIStatus.UNDERWEIGHT,
                color = colorResource(R.color.light_blue)
            )
        else ->
            return Bmi(
                bmi = Pair("", bmi),
                bmiStatus = BMIStatus.OBESITY3,
                color = colorResource(R.color.red )
            )
    }

}