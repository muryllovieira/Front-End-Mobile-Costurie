import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.Storage
import br.senai.sp.jandira.costurie_app.components.GradientButtonSmall
import br.senai.sp.jandira.costurie_app.components.GradientButtonTag
import br.senai.sp.jandira.costurie_app.components.ModalTags2
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.components.WhiteButtonSmall
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.UserRepository
import br.senai.sp.jandira.costurie_app.sqlite_repository.UserRepositorySqlite
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import kotlinx.coroutines.launch
import org.json.JSONObject


@Composable
fun ProfileViewedScreen(
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    viewModel: UserViewModel,
    localStorage: Storage
) {

    var isModalOpen by remember { mutableStateOf(false) }

    val context = LocalContext.current
//    val focusManager = LocalFocusManager.current
//    val scrollState = rememberScrollState()
//
//    var modalTag = ModalTags2()

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

    var fotoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var id = localStorage.lerValor(context, "idUsuario")

    val profileEditSuccess = rememberUpdatedState(viewModel.profileEditSuccess.value)

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(context).data(fotoUri).build()
    )

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

                if (usuarioObject.has("tags")) {
                    val tagsArray = usuarioObject.getJSONArray("tags")
                    val tagsList = mutableListOf<TagsResponse>()

                    // Processar tags como antes
                    for (i in 0 until tagsArray.length()) {
                        val tagObject = tagsArray.getJSONObject(i)
                        val idTag = tagObject.getInt("id_tag")
                        val nomeTag = tagObject.getString("nome_tag")
                        val imagem_tag = tagObject.getString("imagem_tag")
                        val id_categoria = tagObject.getInt("id_categoria")
                        //val nome_categoria = tagObject.getString("nome_categoria")

                        val tagResponse = TagsResponse(idTag, nomeTag, imagem_tag, id_categoria)
                        tagsList.add(tagResponse)

                        viewModel.tags = tagsList
                    }
                } else {
                }

                id_usuario = usuarioObject.getInt("id_usuario")
                nome = usuarioObject.getString("nome")
                descricao = usuarioObject.getString("descricao")
                nome_de_usuario = usuarioObject.getString("nome_de_usuario")
                val fotoUrl = usuarioObject.getString("foto")
                fotoUri = Uri.parse(fotoUrl)
                email = usuarioObject.getString("email")
                cidade = usuarioObject.getString("cidade")
                estado = usuarioObject.getString("estado")
                bairro = usuarioObject.getString("bairro")
                id_localizacao = usuarioObject.getInt("id_localizacao")

                Log.i("Thiago", "${viewModel.nome}, $fotoUri")

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
        val array = UserRepositorySqlite(context).findUsers()

        val user = array[0]

        user(
            id = id!!.toInt(),
            token = user.token,
            viewModel
        )

        if (profileEditSuccess.value == true) {
            viewModel.setProfileEditSuccess(false) // Redefina o sucesso para evitar recargas repetidas
            // A edição de perfil foi bem-sucedida, recarregue os dados do usuário.
            user(id = user.id.toInt(), token = user.token, viewModel)
        }

        Log.e("TAG@", "ProfileScreen: ${user.id}, ${user.token}")
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
                        .height(35.dp)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )

                    Text(
                        color = Color.White,
                        text = stringResource(id = R.string.texto_perfil),
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Image(
                            painter = painterResource(id = R.drawable.icon_chat),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {

                                },
                            alignment = Alignment.TopEnd
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 20.dp)
                        .width(320.dp),
                    Arrangement.Start
                ) {

                    AsyncImage(
                        model = "$fotoUri",
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                BorderStroke(br.senai.sp.jandira.costurie_app.screens.editProfile.borderWidth, Color.White),
                                RoundedCornerShape(10.dp)
                            )
                            .padding(br.senai.sp.jandira.costurie_app.screens.editProfile.borderWidth)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(
                    ) {
                        Text(
                            color = Color.White,
                            text = nome,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.height(28.dp)
                        )

                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            color = Color.White,
                            text = nome_de_usuario,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.height(22.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
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
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.height(20.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    GradientButtonSmall(
                        onClick = { /*TODO*/ },
                        text = stringResource(id = R.string.botao_recomendar),
                        color1 = Color(201, 143, 236, 255),
                        color2 = Color(168, 155, 255, 255)
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(40.dp))

                        WhiteButtonSmall(
                            onClick = {

                            },
                            text = stringResource(id = R.string.botao_recomendacoes).uppercase()
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        WhiteButtonSmall(
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

                    if (viewModel.tags == null) {
                        Row(modifier = Modifier.fillMaxWidth()) {

                        }

                    } else {
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                                .fillMaxWidth(),
                            Arrangement.SpaceEvenly
                        ) {
//                        viewModel.tags?.take(1)?.forEach { tag ->
//                            GradientButtonTag(
//                                onClick = {
//                                    // Faça algo quando uma tag for clicada
//                                },
//                                text = tag.nome_tag,
//                                color1 = Destaque1,
//                                color2 = Destaque2,
//                                viewModel,
//                            )
//                        }
                            if ((viewModel.tags?.size ?: 0) > 1) {
                                ModalTags2(color1 = Destaque1, color2 = Destaque2, viewModel)
                            }
                        }
                    }
                }
            }
        }
    }