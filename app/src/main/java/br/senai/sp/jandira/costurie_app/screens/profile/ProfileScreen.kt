import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GradientButtonTag
import br.senai.sp.jandira.costurie_app.components.ModalTags2
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.components.WhiteButton
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.UserRepository
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject


@Composable
fun ProfileScreen(
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    viewModel: UserViewModel,
) {

    var isModalOpen by remember { mutableStateOf(false) }

    val context = LocalContext.current
//    val focusManager = LocalFocusManager.current
//    val scrollState = rememberScrollState()

    //var modalTag = ModalTags2()

    var id_usuario by remember {
        mutableStateOf(0)
    }

    var nome by remember {
        mutableStateOf("")
    }

    var descricao by remember {
        mutableStateOf("")
    }

    var nome_de_usuario by remember {
        mutableStateOf("")
    }

    var foto by remember {
        mutableStateOf("")
    }

    var cidade by remember {
        mutableStateOf("")
    }

    var estado by remember {
        mutableStateOf("")
    }

    var bairro by remember {
        mutableStateOf("")
    }

    var id_localizacao by remember {
        mutableStateOf(0)
    }

    var email by remember {
        mutableStateOf("")
    }


    fun user(
        id: Int,
        token: String,
        viewModel: UserViewModel
    ) {
        val userRepository = UserRepository()

        lifecycleScope.launch {
            Log.e("ID", "user: $id")
            Log.e("token", "user: $token")

            val response = userRepository.getUser(id, token)

            Log.e("TAG", "user: $response")
            Log.i("TAG", "user: ${response.body()}")

            if (response.isSuccessful) {
                Log.e(MainActivity::class.java.simpleName, "Usuario sucedido")
                Log.e("user", "user: ${response.body()}")

                val jsonString = response.body().toString()
                val jsonObject = JSONObject(jsonString)
                val usuarioObject = jsonObject.getJSONObject("usuario")

                val tagsArray = usuarioObject.getJSONArray("tags")
                val tagsList = mutableListOf<TagsResponse>()

                for (i in 0 until tagsArray.length()) {
                    val tagObject = tagsArray.getJSONObject(i)
                    val idTag = tagObject.getInt("id_tag")
                    val nomeTag = tagObject.getString("nome_tag")

                    val tagResponse = TagsResponse(idTag, nomeTag)
                    tagsList.add(tagResponse)
                }
                id_usuario = usuarioObject.getInt("id_usuario")
                nome = usuarioObject.getString("nome")
                descricao = usuarioObject.getString("descricao")
                nome_de_usuario = usuarioObject.getString("nome_de_usuario")
                foto = usuarioObject.getString("foto")
                email = usuarioObject.getString("email")
                cidade = usuarioObject.getString("cidade")
                estado = usuarioObject.getString("estado")
                bairro = usuarioObject.getString("bairro")
                id_localizacao = usuarioObject.getInt("id_localizacao")

                viewModel.id_usuario = id_usuario
                viewModel.nome = nome
                viewModel.descricao = descricao
                viewModel.nome_de_usuario = nome_de_usuario
                viewModel.foto = foto
                viewModel.email = email
                viewModel.cidade = cidade
                viewModel.estado = estado
                viewModel.bairro = bairro
                viewModel.id_localizacao = id_localizacao
                viewModel.tags = tagsList

            } else {
                val errorBody = response.errorBody()?.string()
                //val errorBody = response.body()
                Log.e(
                    MainActivity::class.java.simpleName,
                    "Erro durante pegar os dados do usuario: ${errorBody}"
                )
                Toast.makeText(
                    context,
                    "Erro durante pegar os dados do usuario",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    LaunchedEffect(key1 = true) {
        user(
            id = 72,
            token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySUQiOjcwLCJpYXQiOjE2OTUwNjUzMTgsImV4cCI6MTcyNTA2NTMxOH0.zr9S70ynlICRSmCybejcI4L481Kl4lBTID2MZJ4PG8c",
            viewModel
        )
    }
    Costurie_appTheme {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forma_tela_perfil),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.TopStart
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 40.dp),
                //horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Text(
                        color = Color.White,
                        text = stringResource(id = R.string.texto_meu_perfil),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .width(280.dp),
                        Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_edit),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {
                                    navController.navigate("editProfile")
                                },
                            alignment = Alignment.TopEnd
                        )

                        Spacer(modifier = Modifier.width(18.dp))

                        Image(
                            painter = painterResource(id = R.drawable.icon_config),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp)
                        .width(320.dp),
                    Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_pic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Column(
                    ) {
                        Text(
                            color = Color.White,
                            text = nome,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.height(28.dp)
                        )

                        Text(
                            color = Color.White,
                            text = nome_de_usuario,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.height(22.dp)
                        )

                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.icon_location),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(23.dp)
                            )

                            Text(
                                color = Color.White,
                                text = "$cidade, $estado",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.height(20.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(40.dp))

                    WhiteButton(
                        onClick = {

                        },
                        text = stringResource(id = R.string.botao_recomendacoes).uppercase()
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    WhiteButton(
                        onClick = {},
                        text = stringResource(id = R.string.botao_recomendados).uppercase()
                    )
                }

                Text(
                    color = Contraste,
                    text = descricao,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    Arrangement.SpaceEvenly
                ) {
                    viewModel.tags.take(1).forEach { tag ->
                        GradientButtonTag(
                            onClick = {
                                // Faça algo quando uma tag for clicada
                            },
                            text = tag.nome_tag,
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                    }
                    if (viewModel.tags.size > 1) {
                        ModalTags2(color1 = Destaque1, color2 = Destaque2, viewModel)
                    }
                }

            }
        }
    }
}
