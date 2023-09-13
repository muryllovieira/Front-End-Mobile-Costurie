package br.senai.sp.jandira.costurie_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste

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

                MainScreen()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreen() {

    val context = LocalContext.current

    Costurie_appTheme {

        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Box (
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.forma1_topo_main),
                        contentDescription = "",
                        modifier = Modifier
                            .height(310.dp)
                            .width(390.dp),
                        alignment = Alignment.TopStart
                    )

                    Column (
                        modifier = Modifier
                            .height(250.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ){
                        Text(
                            color = Color.White,
                            text = stringResource(id = R.string.titulo_app),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 32.sp
                        )

                        Text(
                            color = Color.White,
                            text = stringResource(id = R.string.boas_vindas).uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 24.sp
                        )

                        Text(
                            color = Color.White,
                            text = stringResource(id = R.string.texto_boas_vindas),
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(220.dp),
                            fontSize = 18.sp
                        )
                    }

                }

                Column (
                    modifier = Modifier
                        .height(480.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.foto_principal_main),
                        contentDescription = "",
                        modifier = Modifier
                            .height(240.dp)
                            .width(240.dp),
                        alignment = Alignment.TopStart
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    GradientButton(
                        onClick = {  },
                        text = stringResource(id = R.string.texto_botao_registrar).uppercase(),
                        color1 = Destaque1,
                        color2 = Destaque2
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    GradientButton(
                        onClick = {
                            var openLogin = Intent(context, LoginActivity::class.java)

                            context.startActivity(openLogin)
                        },
                        text = stringResource(id = R.string.texto_botao_login).uppercase(),
                        color1 = Destaque1,
                        color2 = Destaque2
                    )

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


