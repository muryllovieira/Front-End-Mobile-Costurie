package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.Storage
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import br.senai.sp.jandira.costurie_app.viewModel.BairroViewModel
import br.senai.sp.jandira.costurie_app.viewModel.EstadoViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@Composable
fun ModalLocation(
    lifecycleScope: LifecycleCoroutineScope,
    localStorage: Storage
) {
    var isDialogOpen by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val viewModelEstado = viewModel<EstadoViewModel>()
    val viewModelCidade = viewModel<BairroViewModel>()

    var cidadeStateUser by remember { mutableStateOf(localStorage.lerValor(context, "cidade")) }
    var estadoStateUser by remember { mutableStateOf(localStorage.lerValor(context, "estado")) }
    var bairroStateUser by remember { mutableStateOf(localStorage.lerValor(context, "bairro")) }

    Image(
        painter = painterResource(id = R.drawable.filter_icon),
        contentDescription = "",
        modifier = Modifier
            .size(40.dp)
            .clickable {
                isDialogOpen = true
            },
        colorFilter = ColorFilter.tint(Color.White)
    )

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = {
                isDialogOpen = false
            },
            title = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Filtros",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = { isDialogOpen = false },
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_close_24),
                            contentDescription = "",
                            modifier = Modifier.size(45.dp),
                            alignment = Alignment.TopEnd
                        )
                    }
                }

            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    //.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Text(text = "Estados:", fontSize = 20.sp, color = Color.Black)
                    DropdownEstado(
                        lifecycleScope = lifecycleScope,
                        viewModelEstado,
                    ) { selectedEstado ->
                        estadoStateUser = selectedEstado
                    }

                    Text(text = "Cidades:", fontSize = 20.sp, color = Color.Black)
                    DropdownCidade(
                        lifecycleScope = lifecycleScope,
                        viewModelEstado,
                        viewModelCidade
                    ) { selectedCidade ->
                        cidadeStateUser = selectedCidade
                    }

                    Text(text = "Bairros:", fontSize = 20.sp, color = Color.Black)
                    DropdownBairro(
                        lifecycleScope = lifecycleScope,
                        viewModelCidade
                    ) { selectedBairro ->
                        bairroStateUser = selectedBairro
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        WhiteButton(onClick = { /*TODO*/ }, text = "FILTRAR".uppercase())
                    }

                }

            },
            containerColor = colorResource(id = R.color.principal_2),
            confirmButton = {
                Button(
                    onClick = {
                        //isDialogOpen = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent
                    )
                ) {
                    Text(text = "Fechar", color = Color.Transparent)
                }
            }
        )
    }
}