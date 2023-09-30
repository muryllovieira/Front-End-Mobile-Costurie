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
import br.senai.sp.jandira.costurie_app.model.CityResponse
import br.senai.sp.jandira.costurie_app.repository.LocationRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import br.senai.sp.jandira.costurie_app.viewModel.EstadoViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownCidade(
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: EstadoViewModel,
    viewModelCidade: BairroViewModel,
) {

    val context = LocalContext.current

    val siglaEstado = viewModel.estadoSigla

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var cidade by remember {
        mutableStateOf("")
    }

    val cidades = remember { mutableStateListOf<CityResponse>() }

    fun loadCidades(siglaEstado: String) {
        val locationRepository = LocationRepository()
        lifecycleScope.launch {
            val response = locationRepository.getCidades(siglaEstado)

            Log.e("response", "loadCidades: $response", )

            if (response.isSuccessful) {
                val cidadesResponse = response.body()

                cidades.clear()

                cidadesResponse?.forEach { cidade ->
                    var jsonCidade = CityResponse(cidade.id, cidade.nome)
                    cidades.add(jsonCidade)
                }
            } else {
                val errorBody = response.errorBody()?.string()

                Log.e(
                    MainActivity::class.java.simpleName,
                    "Erro durante carregar as cidades: $errorBody"
                )
                Toast.makeText(context, "Erro durante carregar as cidades", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    if(siglaEstado.length > 0){
        LaunchedEffect(key1 = true) {
            loadCidades(siglaEstado)
            viewModel.estadoSigla = ""
        }
    }

//    while (siglaEstado.length > 0){
//        LaunchedEffect(key1 = true) {
//            loadCidades(siglaEstado)
//        }
//    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(
                color = Color.White,
                //colorResource(id = R.color.principal_2),
                shape = RoundedCornerShape(20.dp)
            ),
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
                value = cidade,
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
                cidades.forEach { cidadeNome ->
                    DropdownMenuItem(
                        text = { Text(cidadeNome.nome, color = Contraste2) },
                        onClick = {
                            cidade = cidadeNome.nome
                            isExpanded = false
                            viewModelCidade.bairroID = cidadeNome.id
                            Log.e("PEGA", "DropdownCidade: ${viewModelCidade.bairroID}" )
                        }
                    )
                }
            }

        }
    }


}

//@Preview
//@Composable
//fun DropdownCidadePreview() {
//    DropdownCidade()
//}