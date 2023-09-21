package br.senai.sp.jandira.costurie_app.screens.editProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.DropdownBairro
import br.senai.sp.jandira.costurie_app.components.DropdownCidade
import br.senai.sp.jandira.costurie_app.components.DropdownEstado
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    //navController: NavController,
    //lifecycleScope: LifecycleCoroutineScope
) {

    var nomeState by remember {
        mutableStateOf("")
    }

    var tagDeUsuarioState by remember {
        mutableStateOf("")
    }

    var descricaoState by remember {
        mutableStateOf("")
    }

    Costurie_appTheme {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Image(
                painter = painterResource(id = R.drawable.forma_tela_perfil),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                alignment = Alignment.TopStart
            )
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
                                    .size(45.dp)
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
                        .padding(20.dp, 8.dp, 20.dp, 0.dp)
                ) {
                    Text(
                        text = "NOME",
                        fontSize = 24.sp
                    )
                    CustomOutlinedTextField2(
                        value = nomeState,
                        onValueChange = {
                                        nomeState = it
                        },
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp)
                    )
                    Text(
                        text = "Tag De Usuário",
                        fontSize = 24.sp
                    )
                    CustomOutlinedTextField2(
                        value = tagDeUsuarioState,
                        onValueChange = {
                                        tagDeUsuarioState = it
                        },
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 0.dp, 30.dp, 0.dp),
                        //horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Cidade",
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.width(130.dp))
                        Text(
                            text = "Bairro",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start
                        )

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp, 0.dp, 30.dp, 0.dp),
                        //horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            DropdownCidade()
                            Spacer(modifier = Modifier.width(20.dp))
                            DropdownBairro()
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Estado", fontSize = 24.sp)
                        DropdownEstado()
                    }
                    Text(text = "Descrição", fontSize = 24.sp)
                    CustomOutlinedTextField2(
                        value = descricaoState,
                        onValueChange = {
                                        descricaoState = it
                        },
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )
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