package br.senai.sp.jandira.costurie_app.screens.publish

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.GradientButtonTag
import br.senai.sp.jandira.costurie_app.components.GradientButtonTags
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.Kufam
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PublishScreen(
    navController: NavController
) {

    var titleState by remember {
        mutableStateOf("")
    }

    var descriptionState by remember {
        mutableStateOf("")
    }

    Costurie_appTheme {
        val sheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = sheetState
        )
        val scope = rememberCoroutineScope()
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetShape = RoundedCornerShape(20.dp),
            sheetElevation = 10.dp,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(750.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bar_icon),
                                contentDescription = "",
                                Modifier.size(75.dp)
                            )
                        }

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.close_icon),
                                contentDescription = "",
                                Modifier
                                    .size(35.dp)
                                    .clickable { }
                            )

                            Image(
                                painter = painterResource(id = R.drawable.send_icon),
                                contentDescription = "",
                                Modifier
                                    .size(35.dp)
                                    .clickable { }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Box (
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(110.dp)
                                    .background((Color.White), shape = RoundedCornerShape(20.dp))
                                    .border(
                                        width = 2.dp,
                                        color = Color(168, 155, 255, 255),
                                        shape = RoundedCornerShape(20.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_add_image),
                                    contentDescription = "",
                                    Modifier
                                        .size(50.dp)
                                        .clickable { }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Box(
                            modifier = Modifier
                                .height(70.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 35.dp)
                                .background((Color.White), shape = RoundedCornerShape(60.dp))
                                .border(
                                    width = 2.dp,
                                    color = Color(231, 188, 255, 255),
                                    shape = RoundedCornerShape(60.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(shape = RoundedCornerShape(10.dp))
                                        .background(Color(168, 155, 255, 102)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.mulher_publicacao),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(bottom = 5.dp, end = 2.dp)
                                            .clip(shape = RoundedCornerShape(10.dp)),
                                        contentScale = ContentScale.Crop
                                    )

                                    Icon(
                                        painter = painterResource(id = R.drawable.trash_icon),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(25.dp)
                                            .clickable {  },
                                        tint = Color.White
                                    )
                                }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        CustomOutlinedTextField2(
                            value = titleState,
                            onValueChange = {
                                titleState = it
                            },
                            label = stringResource(id = R.string.titulo_label),
                            borderColor = Color.Transparent,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(62.dp)
                                .padding(horizontal = 35.dp)
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        CustomOutlinedTextField2(
                            value = descriptionState,
                            onValueChange = {
                                descriptionState = it
                            },
                            label = stringResource(id = R.string.descricao_label),
                            borderColor = Color.Transparent,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(horizontal = 35.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = stringResource(id = R.string.tags_title_label),
                                modifier = Modifier
                                    .padding(horizontal = 35.dp),
                                fontFamily = Kufam,
                                fontSize = 18.sp,
                                color = Color.Black
                            )

                        Box(
                            modifier = Modifier
                                .height(120.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 35.dp)
                                .background((Color.White), shape = RoundedCornerShape(20.dp))
                                .border(
                                    width = 2.dp,
                                    color = Color(168, 155, 255, 255),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            GradientButtonTags(
                                onClick = { /*TODO*/ },
                                text = "Teste",
                                color1 = Destaque1,
                                color2 = Destaque2
                            )
                        }
                    }
                }
            },
            sheetBackgroundColor = Color.White,
            sheetPeekHeight = 0.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                    Button(onClick = {
                        scope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }) {
                        Text(text = "Publicar")
                    }
                }
            }
        }
    }