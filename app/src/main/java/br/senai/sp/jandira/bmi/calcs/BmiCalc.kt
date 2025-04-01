package br.senai.sp.jandira.bmi.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.BMIStatus
import br.senai.sp.jandira.bmi.model.Bmi
import kotlin.math.pow

@Composable
fun bmiCalculator(weight: Int, height: Double): Bmi{

    val bmi = weight / height.div(100).pow(2)

    when{
        bmi < 18.5 ->
            return Bmi(
                bmi = Pair( stringResource(R.string.underweight), bmi),
                bmiStatus = BMIStatus.UNDERWEIGHT,
                color = colorResource(R.color.light_blue)
            )
        bmi >= 18.5 && bmi < 25.0 ->
            return Bmi(
                bmi = Pair( stringResource(R.string.normalweight) , bmi),
                bmiStatus = BMIStatus.NORMAL,
                color = colorResource(R.color.light_green )
        )
        bmi >= 25.0 && bmi < 30.0 ->
            return Bmi(
            bmi = Pair( stringResource(R.string.overweight) , bmi),
            bmiStatus = BMIStatus.OVERWEIGHT,
            color = colorResource(R.color.yellow )
        )
        bmi >= 30.0 && bmi < 35.0 ->
            return Bmi(
                bmi = Pair( stringResource(R.string.classs1_weight), bmi),
                bmiStatus = BMIStatus.OBESITY1,
                color = colorResource(R.color.light_orange )
            )
        bmi >= 35.0 && bmi < 40.0 ->
            return Bmi(
                bmi = Pair( stringResource(R.string.classs2_weight), bmi),
                bmiStatus = BMIStatus.OBESITY2,
                color = colorResource(R.color.dark_orange )
            )
        else ->
            return Bmi (
                bmi = Pair( stringResource(R.string.classs3_weight), bmi),
                bmiStatus = BMIStatus.OBESITY3,
                color = colorResource(R.color.red )
            )

    }

}