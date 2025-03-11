package br.senai.sp.jandira.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi.screans.TelaInicial
import br.senai.sp.jandira.bmi.screans.UserDataScream
import br.senai.sp.jandira.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMITheme {

                //lembranca de quais telas o usuario passou e qual foi sua sequencia
                var navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home" //a primeira tela ao abrir o app vai se chamar home
                ){
                    //criacao de rotas para cada uma dessas telas
                    //ao escolher o composable tem que ser o que recebe route
                    composable(
                        route = "home"
                    ){
                        TelaInicial(navController)
                    }
                    composable(
                        route = "user_data"
                    ){
                        UserDataScream()
                    }
                }
            }
        }
    }
}

