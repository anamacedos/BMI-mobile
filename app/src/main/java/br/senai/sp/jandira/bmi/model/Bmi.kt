package br.senai.sp.jandira.bmi.model

import androidx.compose.ui.graphics.Color

data class Bmi(
    var bmi: Pair<String, Double>
    var bmiStatus: BMIStatus = BMIStatus.NORMAL
    var color: Color = Color(0xFFA9E770)
)
