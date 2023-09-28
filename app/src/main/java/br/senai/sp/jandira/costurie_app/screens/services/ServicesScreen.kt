package br.senai.sp.jandira.costurie_app.screens.services

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.components.MenuBar
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

@Composable
fun ServicesScreen (navController: NavController) {
    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            MenuBar()

        }

    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun PreviewServicesScreen () {
//    ServicesScreen()
//}