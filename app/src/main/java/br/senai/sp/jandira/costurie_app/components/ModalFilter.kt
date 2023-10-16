package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel


@Composable
fun ModalFilter(
    viewModel: UserViewModel,

    ) {
    var isDialogOpen by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Button(
        onClick = {
            isDialogOpen = true
        },
        modifier = Modifier
            .background(
                Color.Transparent,
                shape = ShapeButton.large,
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable { },
            colorFilter = ColorFilter.tint(Color.Black)
        )
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = {
                isDialogOpen = false
            },
            title = {
                IconButton(
                    onClick = { isDialogOpen = false },

                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.exit_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp),
                        tint = Color.Black
                    )
                }
            },
            text = {
                Text(text = "Este é o conteúdo do modal.")
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1), // Define o número de colunas por linha
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(viewModel.tags?.toList() ?: emptyList()) { tag ->
                        GradientButtonTag(
                            onClick = {},
                            text = tag.nome_tag,
                            color1 = Destaque1,
                            color2 = Destaque2,
                            textColor = Color.White,
                            tagId = 0
                            //viewModel
                        )
                    }
                }

            },
            containerColor = colorResource(id = R.color.principal_2),
            confirmButton = {
                Button(
                    onClick = {},
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


@Preview(showBackground = true)
@Composable
fun ModalExamplePreview() {
    ModalFilter(viewModel = UserViewModel())
}