package br.senai.sp.jandira.costurie_app.screens.services

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.DefaultAppBar
import br.senai.sp.jandira.costurie_app.components.SearchAppBar
import br.senai.sp.jandira.costurie_app.model.Filtering
import br.senai.sp.jandira.costurie_app.repository.Category
import br.senai.sp.jandira.costurie_app.repository.CategoryRepository
import br.senai.sp.jandira.costurie_app.repository.FilteringRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import coil.compose.AsyncImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen (navController: NavController, lifecycleScope: LifecycleCoroutineScope, filterings: List<Filtering>, categories: List<Category>) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableStateListOf(
            "Teste",
            "Teste2"
        )
    }

    val color = Contraste

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
                    text = stringResource(id = R.string.servicos_filtragem_textfield),
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
                    items(filterings) { filtering ->
                        Card(
                            modifier = Modifier
                                .size(100.dp, 45.dp)
                                .padding(start = 16.dp, 2.dp),
                            backgroundColor = Color.Transparent
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = filtering.name,
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
                ){
                    LazyColumn(
                        modifier = Modifier
                            .padding(18.dp)
                    ) {
                        items(categories) {category ->
                            Card(
                                modifier = Modifier
                                    .size(170.dp, 85.dp)
                                    .padding(2.dp, vertical = 4.dp),
                                backgroundColor = Color.Transparent,
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
                                    model = category.image,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .padding(18.dp)
                    ) {
                        items(categories) {category ->
                            Card(
                                modifier = Modifier
                                    .size(170.dp, 85.dp)
                                    .padding(2.dp, vertical = 4.dp),
                                backgroundColor = Color.Transparent,
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
                            }
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun PreviewServicesScreen () {
//    ServicesScreen(FilteringRepository.getFiltering(), CategoryRepository.getCategories())
//}