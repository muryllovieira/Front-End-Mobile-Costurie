package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.model.NeighborhoodResponse
import br.senai.sp.jandira.costurie_app.repository.LocationRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownBairro(lifecycleScope: LifecycleCoroutineScope, viewModelCidade: BairroViewModel) {

    val context = LocalContext.current

    val idBairro = viewModelCidade.bairroID

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var bairro by remember {
        mutableStateOf("")
    }

    val bairros = remember { mutableStateListOf<NeighborhoodResponse>() }

    fun loadBairros(idBairro: Int) {
        val locationRepository = LocationRepository()
        lifecycleScope.launch {
            val response = locationRepository.getBairros(idBairro)

            Log.e("response", "loadBairros: $response", )

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


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(
                color = Color.White,
                //colorResource(id = R.color.principal_2),
                shape = RoundedCornerShape(20.dp)
            ),
        //contentColor(backgroundColor = Color.White),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it },
            modifier = Modifier.background(
                color = Color.White
            )
        ) {

            TextField(
                value = bairro,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .background(
                        color = Color.White
                    ),
                textStyle = TextStyle(fontSize = 16.sp),

            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.background(
                    color = Color.White
                )
            ) {
                bairros.forEach { bairroNome ->
                    DropdownMenuItem(
                        text = { Text(bairroNome.nome, color = Contraste2) },
                        onClick = {
                            bairro = bairroNome.nome
                            isExpanded = false
//                            viewModelCidade.bairroID = cidadeNome.id
//                            Log.e("PEGA", "DropdownCidade: ${viewModelCidade.bairroID}" )
                        }
                    )
                }
            }

        }
    }


}

//@Preview
//@Composable
//fun DropdownBairroPreview() {
//    DropdownBairro()
//}