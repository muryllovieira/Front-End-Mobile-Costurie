package br.senai.sp.jandira.costurie_app.screens.editProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

@Composable
fun EditProfileScreen(
    //navController: NavController,
    //lifecycleScope: LifecycleCoroutineScope
) {

    Costurie_appTheme {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    //contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.forma_tela_perfil),
                        contentDescription = "",
                        modifier = Modifier
                            .height(240.dp)
                            .width(390.dp),
                        alignment = Alignment.TopStart
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(35.dp)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.save_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(35.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile_pic),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(120.dp)
                            )
                        }

                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 0.dp)
                ) {
                    Text(
                        text = "NOME",
                        fontSize = 24.sp
                    )
                    CustomOutlinedTextField2(
                        value = "Beltrana",
                        onValueChange = {},
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .width(400.dp)
                            .height(62.dp)
                    )
                    Text(
                        text = "Tag De Usuário",
                        fontSize = 24.sp
                    )
                    CustomOutlinedTextField2(
                        value = "@Beltrana_GOD",
                        onValueChange = {},
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .width(400.dp)
                            .height(62.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Cidade",
                            fontSize = 24.sp
                        )
                        Text(
                            text = "Bairro",
                            fontSize = 24.sp
                        )

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        //horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CustomOutlinedTextField2(
                            value = "Barueir",
                            onValueChange = {},
                            borderColor = Color.Transparent,
                            modifier = Modifier
                                .width(150.dp)
                                .height(62.dp)
                        )
                        CustomOutlinedTextField2(
                            value = "sao silvetre",
                            onValueChange = {},
                            borderColor = Color.Transparent,
                            modifier = Modifier
                                .width(150.dp)
                                .height(62.dp)
                        )
                    }

                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfileScreen()
}