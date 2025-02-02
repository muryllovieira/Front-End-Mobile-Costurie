package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.model.NeighborhoodResponse
import br.senai.sp.jandira.costurie_app.repository.LocationRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import coil.size.Size
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownBairro(
    lifecycleScope: LifecycleCoroutineScope,
    viewModelCidade: BairroViewModel,
    onBairroSelected: (String) -> Unit
) {

    val context = LocalContext.current

    val idBairro = viewModelCidade.bairroID

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var bairro by remember {
        mutableStateOf("")
    }

    val bairros = remember { mutableStateListOf<NeighborhoodResponse>() }

    var textFieldSize by remember {
        mutableStateOf(androidx.compose.ui.geometry.Size.Zero)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val heightTextFields by remember {
        mutableStateOf(55.dp)
    }


    fun loadBairros(idBairro: Int) {
        val locationRepository = LocationRepository()
        lifecycleScope.launch {
            val response = locationRepository.getBairros(idBairro)

            Log.e("idCidade", "loadCidades: $idBairro")
            Log.e("response", "loadCidades: ${response.body()}")

            if (response.isSuccessful) {
                val bairrosResponse = response.body()

                bairros.clear()

                bairrosResponse?.forEach { bairro ->
                    var jsonBairro = NeighborhoodResponse(bairro.id, bairro.nome)
                    bairros.add(jsonBairro)
                }
            } else {
                val errorBody = response.errorBody()?.string()

                Log.e(
                    MainActivity::class.java.simpleName,
                    "Erro durante carregar os bairros: $errorBody"
                )
                Toast.makeText(context, "Erro durante carregar os bairros", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    if (idBairro != null && idBairro > 0) {
        LaunchedEffect(key1 = true) {
            loadBairros(idBairro)
            viewModelCidade.bairroID = 0
        }
    }

    Column(
        modifier = Modifier
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
                        .background(Color(252, 246, 255), shape = RoundedCornerShape(15.dp))
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    value = bairro,
                    onValueChange = {
                        bairro = it
                        isExpanded = true
                    },
                    placeholder = {
                        if (bairro.isEmpty()) {
                            Text(
                                text = stringResource(id = R.string.label_dropdown_localizacao),
                                fontSize = 18.sp,
                                color = Contraste2,
                                maxLines = 1
                            )
                        }
                    },
                    colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
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
                androidx.compose.material.Card(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(textFieldSize.width.dp)
                        .background(Color.Transparent),
                    elevation = 15.dp
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .heightIn(max = 150.dp)
                            .background(Color.Transparent),
                    ) {

                        if (bairro.isNotEmpty()) {
                            items(
                                bairros.filter {
                                    it.nome.lowercase()
                                        .contains(bairro.lowercase()) || it.nome.lowercase()
                                        .contains("others")
                                }
                                    .sorted()
                            ) {
                                CategoryItemsBairro(title = it.nome) { title ->
                                    bairro = title
                                    onBairroSelected(title)
                                    isExpanded = false
                                }
                            }
                        } else {
                            items(
                                bairros.sorted()
                            ) {
                                CategoryItemsBairro(title = it.nome) { title ->
                                    bairro = title
                                    onBairroSelected(title)
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
fun CategoryItemsBairro(
    title: String,
    onSelect: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(252, 246, 255))
            .clickable {
                onSelect(title)
            }
            .padding(10.dp)
    ) {
        Text(text = title, color = Color.Black, fontSize = 16.sp)
    }

}