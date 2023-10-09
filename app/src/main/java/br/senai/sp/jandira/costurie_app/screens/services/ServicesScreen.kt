package br.senai.sp.jandira.costurie_app.screens.services

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.SearchAppBar
import br.senai.sp.jandira.costurie_app.model.Filtering
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.CategoriesRepository
import br.senai.sp.jandira.costurie_app.repository.TagsRepository
import br.senai.sp.jandira.costurie_app.sqlite_repository.UserRepositorySqlite
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.lang.reflect.Type

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    filterings: List<Filtering>,
    categories: List<TagsResponse>
) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableStateListOf(
            "Teste",
            "Teste2"
        )
    }

    val color = Contraste

    var context = LocalContext.current

    var listCategory by remember {
        mutableStateOf(listOf<Filtering>())
    }

    var listTags by remember {
        mutableStateOf(listOf<TagsResponse>())
    }


    suspend fun getTags(
        token: String,
        categoria: String,
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

        val tags = getTags(user.token, "GERAL").toMutableList()

        listTags = tags

        Log.d("TAGS", "Número de tags recebidas: ${tags.size}")

    }

    suspend fun getCategories(
        token: String
    ): List<Filtering> {
        val filteringRepository = CategoriesRepository()

        val array = UserRepositorySqlite(context).findUsers()
        val user = array[0]

        val response = filteringRepository.getCategories(user.token)

        if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                val categoriesJson = responseBody.getAsJsonArray("categorias")
                val type: Type = object : TypeToken<List<Filtering>>() {}.type
                val categoriesList: List<Filtering> = Gson().fromJson(categoriesJson, type)

                // Log para verificar as categorias recebidas
                Log.e(MainActivity::class.java.simpleName, "Categorias recebidas")
                Log.e("user", "user: $categoriesList")

                return categoriesList


            }
        } else {
            val errorBody = response.errorBody()?.string()
            Log.e("TODAS AS CATEGORIAS", "Tags: $errorBody")
            Toast.makeText(
                context,
                "Erro durante trazer todas as categorias: $errorBody",
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
        val categories = getCategories(user.token).toMutableList()

        listCategory = categories

        Log.d("CATEGORIAS", "Número de CATEGORIAS recebidas: ${categories.size}")
        Log.d("CATEGORIAS", "Número de CATEGORIAS recebidas: ${categories}")
        //Log.d("TAGS3333", "kkkkkkkkkk: ${viewModelTags.tags}")

    }

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
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, top = 10.dp),
                    text = stringResource(id = R.string.servicos_titulo),
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold
                )

                SearchAppBar(
                    text = stringResource(id = R.string.servicos_categorias_textfield),
                    onTextChange = { },
                    onCloseClicked = { /*TODO*/ },
                    onSearchClicked = { }
                )

                Text(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    text = stringResource(id = R.string.servicos_filtros_text),
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 2.sp
                )

                LazyRow() {
                    items(listCategory) { filtering ->
                        Card(
                            modifier = Modifier
                                .size(100.dp, 45.dp)
                                .padding(start = 16.dp, 2.dp)
                                .clickable {
                                    val categoriaSelecionada = filtering.nome
                                    val array = UserRepositorySqlite(context).findUsers()
                                    val user = array[0]
                                    lifecycleScope.launch {
                                        val tags = getTags(
                                            user.token,
                                            categoriaSelecionada
                                        ).toMutableList()
                                        listTags = tags
                                    }
                                },
                            backgroundColor = Color.Transparent
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = filtering.nome.uppercase(),
                                    modifier = Modifier
                                        .height(20.dp),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Contraste
                                )

                                Canvas(
                                    modifier = Modifier.size(6.dp),
                                    onDraw = {
                                        drawCircle(
                                            color = color
                                        )
                                    }
                                )
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .padding(top = 28.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .padding(18.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        items(listTags) { tags ->
                            Card(
                                modifier = Modifier
                                    .size(170.dp, 85.dp)
                                    .clickable {
                                        val tagSelecionada = tags.nome_tag
                                        Log.d("TAGSELECIONADA", "ServicesScreen: $tagSelecionada")
                                    },
                                shape = RoundedCornerShape(15.dp),
                                border = BorderStroke(
                                    width = 1.dp,
                                    Brush.horizontalGradient(
                                        listOf(
                                            Color(201, 143, 236, 255),
                                            Color(168, 155, 255, 255)
                                        )
                                    )
                                )
                            ) {

                                AsyncImage(
                                    model = tags.imagem,
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )

                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.BottomStart
                                ) {
                                    Text(
                                        text = tags.nome_tag,
                                        fontSize = 18.sp,
                                        color = Color.White,
                                        modifier = Modifier.padding(start = 12.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        style = TextStyle(
                                            shadow = Shadow(
                                                color = Color.Black,
                                                offset = Offset(0f, 6f),
                                            )
                                        )
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