package br.senai.sp.jandira.costurie_app

import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.components.Line
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Costurie_appTheme {
                LoginScreen()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.forma_topo_login),
                        contentDescription = "",
                        alignment = Alignment.TopEnd,
                        modifier = Modifier.fillMaxSize())

                    Image(
                        painter = painterResource(id = R.drawable.forma_baixo_login),
                        contentDescription = "",
                        alignment = Alignment.BottomEnd,
                        modifier = Modifier.fillMaxSize())

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.modal_login),
                            contentDescription = "",
                            alignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(170.dp))

                            Text(
                                text = stringResource(id = R.string.titulo_app),
                                color = Color.White
                                //fontFamily = Fo
                            )
                            //Spacer(modifier = Modifier.height(5.dp))
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .height(60.dp),
                                label = {
                                    Text(text = "E-mail", color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center)
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    containerColor = Color.White
                                )

                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .height(60.dp),
                                label = {
                                    Text(text = "Senha", color = Color.Gray, fontSize = 16.sp, textAlign = TextAlign.Center)
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    containerColor = Color.White
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Column(
                                modifier = Modifier.width(300.dp),
                                horizontalAlignment = Alignment.End,

                            ) {
                                Text(
                                    text = "Escolha a senha?",
                                    color = Color(168,155,255),
                                    textAlign = TextAlign.Right,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold

                                )
                            }

                            GradientButton(
                                onClick = {  },
                                text = stringResource(id = R.string.texto_botao_login).uppercase() ,
                                color1 = Destaque1,
                                color2 = Destaque2
                            )

                            Line()
                        }

                    }
                }

            }
        }
    }
}