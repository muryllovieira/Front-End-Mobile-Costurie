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
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.UserRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import br.senai.sp.jandira.costurie_app.viewModel.EstadoViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import kotlin.math.log

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

    val viewModelFotoUser = viewModel.foto

    var nomeState by remember {
        mutableStateOf(viewModelNome)
    }

    var tagDeUsuarioState by remember {
        mutableStateOf(viewModelTagUsuario)
    }

    var descricaoState by remember {
        mutableStateOf(viewModelDescricao)
    }

    var fotoState by remember {
        mutableStateOf(viewModelFotoUser)
    }

    var cidadeState by remember {
        mutableStateOf(viewModelCidadeUser)

    }

    var estadoState by remember {
        mutableStateOf(viewModelEstadoUser)
    }

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    fun updateUser(
        id_usuario: Int,
        token: String,
        viewModel: UserViewModel,
        id_localizacao: Int,
        cidade: String,
        estado: String,
        bairro: String,
        nome: String,
        descricao: String,
        foto: String,
        nome_de_usuario: String,
        tags: List<TagsResponse>
    ) {
        val userRepository = UserRepository()

        lifecycleScope.launch {
            Log.e("ID", "user: $id_usuario")
            Log.e("token", "user: $token")

            val response = userRepository.updateUser(
                id_usuario,
                token,
                id_localizacao,
                cidade,
                estado,
                bairro,
                nome,
                descricao,
                foto,
                nome_de_usuario,
                tags
            )

            Log.e("TAG", "user: $response")
            Log.i("TAG", "user: ${response.body()}")

            if (response.isSuccessful) {
                Log.e(MainActivity::class.java.simpleName, "Usuário atualizado com sucesso")
                Log.e("user", "user: ${response.body()}")
            } else {
                val errorBody = response.errorBody()?.string()
                val descricao = response.body()?.descricao
                if (descricao != null) {
                    if (descricao.length > 255)
                        Log.e(
                            MainActivity::class.java.simpleName,
                            "Erro durante a atualização dos dados do usuário: ${errorBody}"
                        )
                    Toast.makeText(
                        context,
                        "Descricão grande demais",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Toast.makeText(
                    context,
                    "Erro durante a atualização dos dados do usuário",
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
                                            if (viewModelIdLocalizacao != null) {
                                                updateUser(
                                                    id_usuario = viewModelIdUsuario,
                                                    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySUQiOjcyLCJpYXQiOjE2OTYwODAxNTYsImV4cCI6MTcyNjA4MDE1Nn0.4kXtV1QuyHjFHCxW6wbNiZNLOwbFzEuOJudGfKEcj8I",
                                                    viewModel,
                                                    id_localizacao = viewModelIdLocalizacao,
                                                    bairro = viewModelBairroUser,
                                                    cidade = cidadeState,
                                                    estado = estadoState,
                                                    descricao = descricaoState,
                                                    foto = fotoState,
                                                    nome_de_usuario = tagDeUsuarioState,
                                                    nome = nomeState,
                                                    tags = listOf(
                                                        TagsResponse(2, "Trabalho"),
                                                        TagsResponse(3, "Formal")
                                                    )
                                                )
                                            }
                                        }
                                        navController.navigate("profile")
                                        Log.e("edit", "EditProfileScreen: $viewModelIdUsuario + $viewModelNome", )
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

