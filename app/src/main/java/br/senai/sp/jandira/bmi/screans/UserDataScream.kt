package br.senai.sp.jandira.bmi.screans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScream(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00897B))
    ){
        Text(
            text = stringResource(R.string.Next)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreamPreview() {
    UserDataScream()

}