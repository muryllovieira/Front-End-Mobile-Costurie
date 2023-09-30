package br.senai.sp.jandira.costurie_app.screens.editProfile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.DropdownBairro
import br.senai.sp.jandira.costurie_app.components.DropdownCidade
import br.senai.sp.jandira.costurie_app.components.DropdownEstado
import br.senai.sp.jandira.costurie_app.repository.UserRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import br.senai.sp.jandira.costurie_app.viewModel.EstadoViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    viewModel: UserViewModel
) {

    val viewModelEstado = viewModel<EstadoViewModel>()

    val viewModelCidade = viewModel<BairroViewModel>()

    val viewModelIdUsuario = viewModel.id_usuario

    val viewModelIdLocalizacao = viewModel.id_localizacao

    val viewModelNome = viewModel.nome

    val viewModelDescricao = viewModel.descricao

    val viewModelTagUsuario = viewModel.nome_de_usuario

    val viewModelEstadoUser = viewModel.estado

    val viewModelCidadeUser = viewModel.cidade

    val viewModelBairroUser = viewModel.bairro

    var nomeState by remember {
        mutableStateOf(viewModelNome)
    }

    var tagDeUsuarioState by remember {
        mutableStateOf(viewModelTagUsuario)
    }

    var descricaoState by remember {
        mutableStateOf(viewModelDescricao)
    }

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    fun updateUser(
        id: Int,
        token: String,
        viewModel: UserViewModel
    ) {
        val userRepository = UserRepository()

        //Log.e("TAG", "updateUser: ${userRepository}", )
        lifecycleScope.launch {
            Log.e("ID", "user: $id")
            Log.e("token", "user: $token")

            val response = userRepository.updateUser(id, token)

            Log.e("TAG", "user: $response")
            Log.i("TAG", "user: ${response.body()}")

            if (response.isSuccessful) {
                Log.e(MainActivity::class.java.simpleName, "Usuario atualizado com sucesso")
                Log.e("user", "user: ${response.body()}")
            } else {
                val errorBody = response.errorBody()?.string()
                //val errorBody = response.body()
                Log.e(
                    MainActivity::class.java.simpleName,
                    "Erro durante atualizar os dados do usuario: ${errorBody}"
                )
                Toast.makeText(
                    context,
                    "Erro durante atualização dos dados do usuario",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

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
                                    .clickable {
                                        navController.navigate("profile")
                                    }
                            )

                            Image(
                                painter = painterResource(id = R.drawable.save_icon),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(35.dp)
                                    .clickable {
                                        if (viewModelIdUsuario != null) {
                                            updateUser(
                                                id = viewModelIdUsuario,
                                                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySUQiOjcwLCJpYXQiOjE2OTUwNjUzMTgsImV4cCI6MTcyNTA2NTMxOH0.zr9S70ynlICRSmCybejcI4L481Kl4lBTID2MZJ4PG8c",
                                                viewModel
                                            )
                                        }
                                    }
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
                        .verticalScroll(scrollState)
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
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Cidade", fontSize = 24.sp)
                        DropdownCidade(
                            lifecycleScope = lifecycleScope,
                            viewModelEstado,
                            viewModelCidade
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Bairro", fontSize = 24.sp)
                        DropdownBairro(lifecycleScope = lifecycleScope, viewModelCidade)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Estado", fontSize = 24.sp)
                        DropdownEstado(lifecycleScope = lifecycleScope, viewModelEstado)
                    }
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(30.dp, 0.dp, 30.dp, 0.dp),
//                        //horizontalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        Row(modifier = Modifier.fillMaxWidth()) {
//                            DropdownCidade()
//                            Spacer(modifier = Modifier.width(20.dp))
//                            DropdownBairro()
//                        }
//                    }
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

