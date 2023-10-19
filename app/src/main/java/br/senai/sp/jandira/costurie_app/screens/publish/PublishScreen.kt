package br.senai.sp.jandira.costurie_app.screens.publish

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublishScreen(navController: NavController) {
    var openBottomSheet by remember { mutableStateOf(false) }
    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Publicar",
                    color = Color.Red)
                Button(
                    onClick = { openBottomSheet = true },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Show Bottom Sheet")
                    if (openBottomSheet) {
//                        ModalPublication(
//                            onDismissRequest = { openBottomSheet = false }
//                        ) {
//                            Column(
//                                modifier = Modifier.padding(16.dp)
//                            ) {
//                                Text(
//                                    text = "This is the content of the bottom sheet",
//                                    fontSize = 20.sp
//                                )
//
//                                Button(
//                                    onClick = { openBottomSheet = false },
//                                    modifier = Modifier.padding(top = 16.dp)
//                                ) {
//                                    Text("Close Bottom Sheet")
//                                }
//                            }
//                        }
                    }
                }
            }


        }

    }
}