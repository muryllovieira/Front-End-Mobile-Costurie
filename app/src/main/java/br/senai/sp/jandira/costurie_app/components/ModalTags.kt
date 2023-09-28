package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2

@Composable
fun ModalTagsScreen(
    isOpen: Boolean,
    onDismiss: () -> Unit
) {

    if (isOpen) {
        Log.i("teste Modal", "ModalTagsScreen: ${isOpen}")
        // Crie um fundo escurecido para a modal
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
                .clickable { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            // Conteúdo da modal
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(500.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .width(300.dp)
                        .height(500.dp)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "teste",
                        fontSize = 32.sp,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2), // Define que haverá 2 colunas por linha
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            items(6) { index ->
                                GradientButtonTag(
                                    onClick = { /*TODO*/ },
                                    text = "tag",
                                    color1 = Destaque1,
                                    color2 = Destaque2
                                )
                            }
                        }
                    )
//                    LazyColumn(
//                        verticalArrangement = Arrangement.SpaceBetween,
//                        horizontalAlignment = Alignment.CenterHorizontally,
////                        modifier = Modifier
////                            .height(300.dp)
//                    ) {
//                        items(6) {
//                            GradientButtonTag(
//                                onClick = { /*TODO*/ },
//                                text = "tag",
//                                color1 = Destaque1,
//                                color2 = Destaque2
//                            )
//
//                        }
//                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    GradientButton(
                        onClick = { onDismiss() },
                        text = "Fechar",
                        color1 = Destaque1,
                        color2 = Destaque2
                    )
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun ModalTagsScreenPreview() {
//    ModalTagsScreen()
//}