package br.senai.sp.jandira.costurie_app

import ProfileScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.sp.jandira.costurie_app.screens.chats.ChatsScreen
import br.senai.sp.jandira.costurie_app.screens.editProfile.EditProfileScreen
import br.senai.sp.jandira.costurie_app.screens.editProfile.TagsEditProfileScreen
import br.senai.sp.jandira.costurie_app.screens.explore.ExploreScreen
import br.senai.sp.jandira.costurie_app.screens.home.HomeScreen
import br.senai.sp.jandira.costurie_app.screens.loading.LoadingScreen
import br.senai.sp.jandira.costurie_app.screens.login.LoginScreen
import br.senai.sp.jandira.costurie_app.screens.main.MainScreen
import br.senai.sp.jandira.costurie_app.screens.password.PasswordScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.DescriptionScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.LocationScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.NameScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.ProfilePicScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.TagSelectScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.TypeProfileScreen
import br.senai.sp.jandira.costurie_app.screens.register.RegisterScreen
import br.senai.sp.jandira.costurie_app.screens.services.ServicesScreen
import br.senai.sp.jandira.costurie_app.screens.tradePassword.TradePasswordScreen
import br.senai.sp.jandira.costurie_app.screens.validationCode.ValidationCodeScreen
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.PasswordResetViewModel
import br.senai.sp.jandira.costurie_app.viewModel.TagsViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            Costurie_appTheme {
                val navController = rememberAnimatedNavController()
                val viewModelPassword = viewModel<PasswordResetViewModel>()
                val viewModelUser = viewModel<UserViewModel>()
                val viewModelTags = viewModel<TagsViewModel>()
                val localStorage: Storage = Storage()
                AnimatedNavHost(
                    navController = navController,

                    startDestination = "services")


                {
                    composable(route = "main") { MainScreen(navController = navController) }
                    composable(route = "register") { RegisterScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "login") { LoginScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "password") { PasswordScreen(navController = navController, lifecycleScope = lifecycleScope, viewModelPassword) }
                    composable(route = "validationCode") { ValidationCodeScreen(navController = navController, lifecycleScope = lifecycleScope, viewModelPassword) }
                    composable(route = "tradePassword") { TradePasswordScreen(navController = navController, lifecycleScope = lifecycleScope, viewModelPassword) }
                    composable(route = "loading") { LoadingScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "home") { HomeScreen(navController = navController, lifecycleScope = lifecycleScope, viewModelUser) }
                    composable(route = "explore") { ExploreScreen(navController = navController) }
                    composable(route = "services") { ServicesScreen(navController = navController, lifecycleScope = lifecycleScope, categories = emptyList(), filterings = emptyList()) }
                    composable(route = "chats") { ChatsScreen(navController = navController) }
                    composable(route = "profile") { ProfileScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel = viewModelUser) }
                    composable(route = "editProfile") { EditProfileScreen(lifecycleScope = lifecycleScope, navController = navController, viewModel = viewModelUser) }
                    composable(route = "tagsEditProfile") { TagsEditProfileScreen(lifecycleScope = lifecycleScope, navController = navController, viewModelUser = viewModelUser, viewModelTags = viewModelTags) }

                    //telas de personalização
                    composable(route = "name") { NameScreen(navController = navController, localStorage) }
                    composable(route = "foto") { ProfilePicScreen(navController = navController, localStorage, lifecycleScope = lifecycleScope) }
                    composable(route = "description") { DescriptionScreen(navController = navController, localStorage, lifecycleScope = lifecycleScope) }
                    composable(route = "location") { LocationScreen(navController = navController,lifecycleScope = lifecycleScope) }
                    composable(route = "profileType") { TypeProfileScreen(navController = navController,lifecycleScope = lifecycleScope) }
                    composable(route = "tagSelection") { TagSelectScreen(lifecycleScope = lifecycleScope) }
                    }
                }
            }
        }
}
