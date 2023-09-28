package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.costurie_app.MainActivity
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.repository.LocationRepository
import br.senai.sp.jandira.costurie_app.repository.LoginRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.viewModel.EstadoViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownEstado(lifecycleScope: LifecycleCoroutineScope, viewModel: EstadoViewModel) {

    val context = LocalContext.current

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val estados = remember { mutableStateListOf<String>() }

    var estado by remember {
        mutableStateOf("")
    }

    fun loadEstados(
        //viewModel: EstadoViewModel
    ) {
        val locationRepository = LocationRepository()
        lifecycleScope.launch {
            val response = locationRepository.getEstados()

            if (response.isSuccessful) {
                val estadosResponse = response.body()
                estadosResponse?.forEach { estado ->
                    estados.add(estado.sigla)
//                    viewModel.estadoSigla = estado.sigla
                }
            } else {
                val errorBody = response.errorBody()?.string()

                Log.e(
                    MainActivity::class.java.simpleName,
                    "Erro durante carregar os estados: $errorBody"
                )
                Toast.makeText(context, "Erro durante carregar os estados", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    LaunchedEffect(key1 = true) {
        loadEstados()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(
                color = Color.White,
//                colorResource(id = R.color.principal_2),
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
                value = estado,
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
                estados.forEach { estadoSigla ->
                    DropdownMenuItem(
                        text = { Text(estadoSigla, color = Contraste2) },
                        onClick = {
                            estado = estadoSigla
                            isExpanded = false
                            viewModel.estadoSigla = estadoSigla
                            Log.e("PEGA", "DropdownEstado: ${viewModel.estadoSigla}" )
                        }
                    )
                }
            }
        }
    }
}

