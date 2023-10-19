package br.senai.sp.jandira.costurie_app.screens.publish

import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublishScreen(navController: NavController) {
    var openBottomSheet by remember { mutableStateOf(false) }
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
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
                ) {
                    Row (
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

                    Spacer(modifier = Modifier.height(15.dp))

                    Row (
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, top = 60.dp, end = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = "",
                            Modifier
                                .size(35.dp)
                                .clickable {  }
                        )

                        Image(
                            painter = painterResource(id = R.drawable.send_icon),
                            contentDescription = "",
                            Modifier
                                .size(35.dp)
                                .clickable {  }
                        )
                    }
                }
        },
            sheetBackgroundColor = Color.White,
            sheetPeekHeight = 0.dp
        ) {
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "Publicar",
                    color = Color.Red)
                Button(
                    onClick = { openBottomSheet = true },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Show Bottom Sheet")
                    if (openBottomSheet) {
//                        ModalPublication(
//                            onDismissRequest = { openBottomSheet = false }
//                        ) {
//                            Column(
//                                modifier = Modifier.padding(16.dp)
//                            ) {
//                                Text(
//                                    text = "This is the content of the bottom sheet",
//                                    fontSize = 20.sp
//                                )
//
//                                Button(
//                                    onClick = { openBottomSheet = false },
//                                    modifier = Modifier.padding(top = 16.dp)
//                                ) {
//                                    Text("Close Bottom Sheet")
//                                }
//                            }
//                        }
                    }

                Button(onClick = {
                    scope.launch {
                        if(sheetState.isCollapsed) {
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

@Preview(showBackground = true)
@Composable
fun PublishScreenPreview() {
    PublishScreen()
}