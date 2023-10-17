package br.senai.sp.jandira.costurie_app.screens.home

import ProfileScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.Storage
import br.senai.sp.jandira.costurie_app.components.TextMenuBar
import br.senai.sp.jandira.costurie_app.screens.chats.ChatsScreen
import br.senai.sp.jandira.costurie_app.screens.explore.ExploreScreen
import br.senai.sp.jandira.costurie_app.screens.publish.PublishScreen
import br.senai.sp.jandira.costurie_app.screens.services.ServicesScreen
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.UserTagViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen (navController: NavController,lifecycleScope: LifecycleCoroutineScope, viewModelUserViewModel: UserViewModel) {

    val items = listOf(
        BottomnavigationBarItem(
            route = "explore",
            selected = "Home",
            unselected = painterResource(id = R.drawable.home_icon),
            hasNews = false
        ),
        BottomnavigationBarItem(
            route = "services",
            selected = "Serviços",
            unselected = painterResource(id = R.drawable.services_icon),
            hasNews = false
        ),
        BottomnavigationBarItem(
            route = "publicar",
            selected = "Publicar",
            unselected = painterResource(id = R.drawable.center_button_bar),
            hasNews = false
        ),
        BottomnavigationBarItem(
            route = "chats",
            selected = "Conversas",
            unselected = painterResource(id = R.drawable.messages_icon),
            hasNews = false
        ),
        BottomnavigationBarItem(
            route = "profile",
            selected = "Perfil",
            unselected = painterResource(id = R.drawable.profile_icon),
            hasNews = false
        )
    )

    var selectedIndexItem by rememberSaveable {
        mutableStateOf(0)
    }


    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Scaffold(
                containerColor = Color.Blue,
                bottomBar = {
                    NavigationBar(
                        modifier = Modifier
                            .height(80.dp)
                            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                            .shadow(elevation = 15.dp)
                            .clip(shape = RoundedCornerShape(15.dp)),
                        containerColor = Color.White,
                        contentColor = Color.Transparent
                    ) {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White
                                ),
                                selected = selectedIndexItem == index,
                                onClick = {
                                    selectedIndexItem = index

                                },
                                icon = {
                                    BadgedBox(
                                        badge = {

                                        }
                                    ) {
                                        if (selectedIndexItem == index) {
                                            TextMenuBar(text = item.selected.uppercase())
                                        } else {
                                            if (index == 2) {
                                                Image(
                                                    painter = item.unselected,
                                                    modifier = Modifier.size(70.dp),
                                                    contentDescription = item.route
                                                )
                                            } else {
                                                Image(
                                                    painter = item.unselected,
                                                    modifier = Modifier.size(22.dp),
                                                    contentDescription = item.route
                                                )
                                            }
                                        }
                                    }

                                })
                        }
                    }
                }
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    val localStorage: Storage = Storage()
                    if (selectedIndexItem == 0) {
                        ExploreScreen(navController = navController)
                    } else if (selectedIndexItem == 1) {
                        ServicesScreen(navController = navController, lifecycleScope =  lifecycleScope, filterings = emptyList(), categories = emptyList(), viewModelUserTags = UserTagViewModel(), localStorage = localStorage)
                    } else if (selectedIndexItem == 2) {
                        PublishScreen(navController = navController)
                    } else if (selectedIndexItem == 3) {
                        ChatsScreen(navController = navController)
                    } else {
                        ProfileScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel = viewModelUserViewModel)
                    }
                }

            }

        }
    }
}
    data class BottomnavigationBarItem(
        val route: String,
        val selected: String,
        val unselected: Painter,
        val hasNews: Boolean,
        val badgeCount: Int? = null
    )