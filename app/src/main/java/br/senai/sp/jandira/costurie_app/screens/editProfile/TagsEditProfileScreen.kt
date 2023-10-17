package br.senai.sp.jandira.costurie_app.screens.editProfile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GradientButtonTag
import br.senai.sp.jandira.costurie_app.components.GradientButtonTags
import br.senai.sp.jandira.costurie_app.model.TagResponse
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.TagsRepository
import br.senai.sp.jandira.costurie_app.sqlite_repository.UserRepositorySqlite
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.viewModel.TagsViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagsEditProfileScreen(
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    viewModelUser: UserViewModel,
    viewModelTags: TagsViewModel,
) {

    var context = LocalContext.current


    val scrollState = rememberScrollState()


    suspend fun getTags(
        token: String,
        categoria: String
    ): List<TagsResponse> {
        val tagRepository = TagsRepository()

        val array = UserRepositorySqlite(context).findUsers()
        val user = array[0]

        val response = tagRepository.getTags(user.token, categoria)

        if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                val tagsJson = responseBody.getAsJsonArray("tags")
                val type: Type = object : TypeToken<List<TagsResponse>>() {}.type
                val tagsList: List<TagsResponse> = Gson().fromJson(tagsJson, type)

                // Log para verificar as tags recebidas
                Log.e(MainActivity::class.java.simpleName, "Tags recebidas")
                Log.e("user", "user: $tagsList")

                return tagsList
            }
        } else {
            val errorBody = response.errorBody()?.string()
            Log.e("TODAS AS TAGS", "Tags: $errorBody")
            Toast.makeText(
                context,
                "Erro durante trazer todas as tags: $errorBody",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Se algo deu errado ou não há tags, retorne uma lista vazia
        return emptyList()
    }

    LaunchedEffect(Unit) {
        val array = UserRepositorySqlite(context).findUsers()
        val user = array[0]

        // Obtenha as tags e converta para uma lista mutável
        val tags = getTags(user.token, "GERAL").toMutableList()

        viewModelTags.tags = tags

        Log.d("TAGS", "Número de tags recebidas: ${tags.size}")
        Log.d("TAGS3333", "kkkkkkkkkk: ${viewModelTags.tags}")

    }


    Costurie_appTheme {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {


            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                            .shadow(elevation = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
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
                                            navController.popBackStack()
                                        }
                                )
                            }
                            Text(
                                color = Color.Black,
                                text = "Você pode escolher uma tag para seu perfil",
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.width(310.dp),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Log.i(
                                    "TAGSjhkgvsdakjgh",
                                    "Dados em viewModelUser.tags: ${viewModelTags.tags}"
                                )

                                var arrayTags by remember { mutableStateOf(listOf<TagResponse>()) }

                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(2),
                                    contentPadding = PaddingValues(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    modifier = Modifier.fillMaxHeight(0.85f)
                                ) {
                                    viewModelTags.tags?.let { tags ->
                                        items(tags) { tag ->
                                            var cor1 by remember {
                                                mutableStateOf(0x5C2C0C)
                                            }
                                            var cor2 by remember {
                                                mutableStateOf(0x5C2C0C)
                                            }

                                            var isChecked by remember { mutableStateOf(false) }

                                            var altura = 30

                                            if (tag.nome_tag.length > 26) {
                                                altura = 48
                                            }

                                            Row(

                                            ) {
                                                GradientButtonTags(
                                                    onClick = {
                                                        val nome = tag.nome_tag
                                                        val id = tag.id
                                                        val imagem = tag.imagem
                                                        val id_categoria = tag.id_categoria
                                                        //val nome_categoria = tag.nome_categoria

                                                        if (!isChecked) {
                                                            isChecked = true
                                                            cor1 = 0xFFFCF6FF.toInt()
                                                            cor2 = 0xFFA89BFF.toInt()
                                                            var jsonTags = TagResponse(id, nome)
                                                            arrayTags = arrayTags + jsonTags
                                                            Log.e("Eu", "$nome + $id")
                                                        } else {
                                                            isChecked = false
                                                            cor1 = 0xFFC98FEC.toInt()
                                                            cor2 = 0xFFA89BFF.toInt()
                                                            arrayTags = arrayTags.filter { it.id != id }
                                                            Log.e("Murilo e Luiz e Eu", "${arrayTags}")
                                                        }
                                                    },
                                                    text = tag.nome_tag,
                                                    color1 = Destaque1,
                                                    color2 = Destaque2,
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }

            }
        }
    }
}











