package br.senai.sp.jandira.costurie_app.components


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuBar() {
    Costurie_appTheme {

        val items = listOf(
            BottomnavigationBarItem(
                title = "home",
                selectedIcon = "Home",
                unselectedIcon = painterResource(id = R.drawable.homeBar),
                hasNews = false
            ),
            BottomnavigationBarItem(
                title = "serviços",
                selectedIcon = "Serviços",
                unselectedIcon = painterResource(id = R.drawable.servicosBar),
                hasNews = false
            ),
            BottomnavigationBarItem(
                title = "conversas",
                selectedIcon = "Conversas",
                unselectedIcon = painterResource(id = R.drawable.conversasBar),
                hasNews = false
            ),
            BottomnavigationBarItem(
                title = "perfil",
                selectedIcon = "Perfil",
                unselectedIcon = painterResource(id = R.drawable.perfilBar),
                hasNews = false
            )
        )

        var selectedIdexItem by rememberSaveable {
            mutableStateOf(0)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed{index, item ->
                            NavigationBarItem(
                                selected = selectedIdexItem == index,
                                onClick = { 
                                          selectedIdexItem = index
                                          // navController.navigate(item.title)
                                },
                                label = {
                                        Text(text = item.title)
                                },
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            
                                        }
                                    ) {
                                        Icon(painter = item.unselectedIcon,
                                            contentDescription = item.title)
                                    }
                                })
                        }
                    }
                }
            ) {

            }
        }
    }
}

data class BottomnavigationBarItem(
    val title: String,
    val selectedIcon: String,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Preview(showBackground = true)
@Composable
fun PreviewMenuBar() {
    MenuBar()
}