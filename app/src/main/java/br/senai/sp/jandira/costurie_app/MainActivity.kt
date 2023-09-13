package br.senai.sp.jandira.costurie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.senai.sp.jandira.costurie_app.screens.main.MainScreen
import br.senai.sp.jandira.costurie_app.screens.validationCode.ValidationCodeScreen
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Costurie_appTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "main") {
                        composable(route = "main") { br.senai.sp.jandira.costurie_app.screens.main.MainScreen(
                            navController = navController
                        )}
                        composable(route = "login") { br.senai.sp.jandira.costurie_app.screens.login.LoginScreen(
                            navController = navController
                        )}
                        composable(route = "password") { br.senai.sp.jandira.costurie_app.screens.password.PasswordScreen(
                            navController = navController
                        )}
                        composable(route = "register") { br.senai.sp.jandira.costurie_app.screens.register.RegisterScreen(
                            navController = navController 
                        )}
                        composable(route = "validation") { br.senai.sp.jandira.costurie_app.screens.validationCode.ValidationCodeScreen(
                            navController = navController
                        )}
                    }
                }
            }
        }
    }
}


