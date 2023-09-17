package br.senai.sp.jandira.costurie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.lifecycleScope
import br.senai.sp.jandira.costurie_app.screens.loading.LoadingScreen
import br.senai.sp.jandira.costurie_app.screens.login.LoginScreen
import br.senai.sp.jandira.costurie_app.screens.main.MainScreen
import br.senai.sp.jandira.costurie_app.screens.password.PasswordScreen
import br.senai.sp.jandira.costurie_app.screens.register.RegisterScreen
import br.senai.sp.jandira.costurie_app.screens.validationCode.ValidationCodeScreen

import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
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
                AnimatedNavHost(
                    navController = navController,
                    startDestination = "main")
                {
                    composable(route = "main") { MainScreen(navController = navController)}
                    composable(route = "register") { RegisterScreen(navController = navController, lifecycleScope = lifecycleScope)}
                    composable(route = "login") { LoginScreen(navController = navController, lifecycleScope = lifecycleScope)}
                    composable(route = "password") { PasswordScreen(navController = navController, onEmailEntered = {_: String ->},  lifecycleScope = lifecycleScope)}
                    composable(route = "validationCode") { ValidationCodeScreen(navController = navController)}
                    composable(route = "loading") { LoadingScreen(navController = navController, lifecycleScope = lifecycleScope) }
                }
            }
        }
    }

}