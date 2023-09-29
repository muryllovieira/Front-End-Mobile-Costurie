package br.senai.sp.jandira.costurie_app

import ProfileScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.sp.jandira.costurie_app.screens.editProfile.EditProfileScreen
import br.senai.sp.jandira.costurie_app.screens.loading.LoadingScreen
import br.senai.sp.jandira.costurie_app.screens.login.LoginScreen
import br.senai.sp.jandira.costurie_app.screens.main.MainScreen
import br.senai.sp.jandira.costurie_app.screens.password.PasswordScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.DescriptionScreen
import br.senai.sp.jandira.costurie_app.screens.personalization.LocationScreen

import br.senai.sp.jandira.costurie_app.screens.personalization.TypeProfileScreen

import br.senai.sp.jandira.costurie_app.screens.register.RegisterScreen
import br.senai.sp.jandira.costurie_app.screens.services.ServicesScreen
import br.senai.sp.jandira.costurie_app.screens.tradePassword.TradePasswordScreen
import br.senai.sp.jandira.costurie_app.screens.validationCode.ValidationCodeScreen
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.viewModel.PasswordResetViewModel
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
                val viewModel = viewModel<PasswordResetViewModel>()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = "profile")

                {
                    composable(route = "main") { MainScreen(navController = navController) }
                    composable(route = "register") { RegisterScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "login") { LoginScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "password") { PasswordScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel) }
                    composable(route = "validationCode") { ValidationCodeScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel) }
                    composable(route = "tradePassword") { TradePasswordScreen(navController = navController, lifecycleScope = lifecycleScope, viewModel) }
                    composable(route = "loading") { LoadingScreen(navController = navController, lifecycleScope = lifecycleScope) }
                    composable(route = "services") { ServicesScreen(navController = navController) }
                    composable(route = "type") { TypeProfileScreen(navController = navController) }
                    //composable(route = "foto") { ProfilePicScreen(navController = navController) }
                    composable(route = "editProfile") { EditProfileScreen(lifecycleScope = lifecycleScope) }
                    composable(route = "profile") { ProfileScreen(lifecycleScope = lifecycleScope) }
                    composable(route = "description") { DescriptionScreen() }
                    composable(route = "location") { LocationScreen(lifecycleScope = lifecycleScope) }
                    }
                }
            }
        }
    }
