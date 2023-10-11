package br.senai.sp.jandira.costurie_app.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Card
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.ModalFilter
import br.senai.sp.jandira.costurie_app.components.SearchAppBar
import br.senai.sp.jandira.costurie_app.testes.Profile
import br.senai.sp.jandira.costurie_app.testes.ProfileRepository
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import coil.compose.AsyncImage

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun typeProfileScreenPreview() {
//    TypeProfileScreen()
//}

@Composable
fun ProfileListScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: UserViewModel,
    profiles: List<Profile>
) {

    var pesquisaState by remember {
        mutableStateOf("")
    }

    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box (){
                    Image(
                        painter = painterResource(id = R.drawable.retangulo_topo),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        alignment = Alignment.TopEnd
                    )
                    Row (
                        modifier = Modifier
                            .width(370.dp)
                            .padding(top = 15.dp, start = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "",
                            modifier = Modifier.size(45.dp)
                        )

                        CustomOutlinedTextField2(
                            value = pesquisaState,
                            onValueChange = {
                                pesquisaState = it
                            },
                            label = stringResource(id = R.string.lista_de_perfis_textfield),
                            borderColor = Color.Transparent,
                            modifier = Modifier
                                .width(260.dp)
                                .height(62.dp)
                        )

                        ModalFilter(viewModel = UserViewModel())
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(profiles) {profile ->
                        Card(
                            modifier = Modifier
                                .size(380.dp, 85.dp)
                                .padding(start = 8.dp, top = 4.dp, bottom = 4.dp),
                            backgroundColor = Color.White,
                            shape = RoundedCornerShape(15.dp),
                            elevation = AppBarDefaults.TopAppBarElevation
                        ) {
                            Row (
                                modifier = Modifier
                                    .width(300.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.profile_pic),
                                    modifier = Modifier.size(40.dp),
                                    contentDescription = ""
                                )

                                Text(
                                    text = profile.name,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .width(250.dp)
                                        .height(25.dp),
                                    fontSize = 15.sp,
                                    color = Contraste
                                )
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
//fun PreviewProfileListScreen() {
//    ProfileListScreen(ProfileRepository.getProfiles())
//}
