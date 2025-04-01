package br.senai.sp.jandira.bmi.utils

import br.senai.sp.jandira.bmi.model.BMIStatus
import java.util.Locale

fun numberFormat(number: Double) =//ela recebe um no=umero no formato double e devolve uma string

        String.format(
        Locale.getDefault(),
        "%.1f",
        number
    )
//quando tem uma função que só tem uma instruçÃO, PODE TIRAR AS CHAVES E O RETURN


fun isFilled(userStatus: BMIStatus, status: BMIStatus): Boolean{
    if (userStatus == status){
        return true
    }else{
        return false
    }
}