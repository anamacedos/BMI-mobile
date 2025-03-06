package br.senai.sp.jandira.bmi.screans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScream(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00897B))
    ){
//        Text(
//            text = //stringResource(R.string.Next)
//        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            shape = RoundedCornerShape(
                topStart =
            )
        ) {

        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreamPreview() {
    UserDataScream()

}