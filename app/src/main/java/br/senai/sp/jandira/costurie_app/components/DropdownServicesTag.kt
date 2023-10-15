package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.repository.TagsRepository
import br.senai.sp.jandira.costurie_app.sqlite_repository.UserRepositorySqlite
import br.senai.sp.jandira.costurie_app.viewModel.UserTagViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownServicesTag(
    lifecycleScope: LifecycleCoroutineScope,
    list: List<TagsResponse>,
    onTagSelected: (String) -> Unit,
    viewModelUserTags: UserTagViewModel,
    navController: NavController

) {

    val context = LocalContext.current

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val tags = remember { mutableStateListOf<String>() }

    var listTags by remember {
        mutableStateOf(listOf<TagsResponse>())
    }

    var tag by remember {
        mutableStateOf("")
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val heightTextFields by remember {
        mutableStateOf(55.dp)
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

    }

    Column(
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 6.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    isExpanded = false
                }
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.fillMaxWidth()) {
                androidx.compose.material.TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(heightTextFields)
                        .border(
                            width = 1.8.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    value = tag,
                    onValueChange = {
                        tag = it
                        isExpanded = true
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = { isExpanded = !isExpanded }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Rounded.KeyboardArrowDown,
                                contentDescription = "arrow",
                                tint = Color.Black
                            )
                        }
                    }
                )
            }

            AnimatedVisibility(visible = isExpanded) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(textFieldSize.width.dp),
                    elevation = 15.dp
                ) {

                    LazyColumn(
                        modifier = Modifier.heightIn(max = 150.dp),
                    ) {

                        if (tag.isNotEmpty()) {
                            items(
                                listTags.filter {
                                    it.nome_tag.lowercase()
                                        .contains(tag.lowercase()) || it.nome_tag.lowercase()
                                        .contains("others")
                                }
                                    .sortedBy { it.nome_tag }
                            ) {
                                CategoryItemsTags(title = it.nome_tag, id = it.id) { title, id ->
                                    tag = title
                                    onTagSelected(title)
                                    viewModelUserTags.nome = title
                                    viewModelUserTags.id = id
                                    isExpanded = false
                                }
                            }
                        } else {
                            items(
                                listTags.sortedBy { it.nome_tag }
                            ) {
                                CategoryItemsTags(title = it.nome_tag, id = it.id) { title, id ->
                                    tag = title
                                    onTagSelected(title)
                                    viewModelUserTags.nome = title
                                    viewModelUserTags.id = id
                                    isExpanded = false
                                }
                            }
                        }

                    }

                }
            }

        }

    }
}

@Composable
fun CategoryItemsTags(
    title: String,
    id: Int,
    onSelect: (String, Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(title, id)
            }
            .padding(10.dp)
    ) {
        Text(text = title, color = Color.Black, fontSize = 16.sp)
    }
}