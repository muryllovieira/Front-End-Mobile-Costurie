package br.senai.sp.jandira.costurie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.components.CaixaDeTexto
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.components.Line
import br.senai.sp.jandira.costurie_app.components.WhiteButton
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.Principal1
import br.senai.sp.jandira.costurie_app.ui.theme.Principal2

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Costurie_appTheme {
                RegisterScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterScreen() {
    Costurie_appTheme {

        var textstate  by remember  { mutableStateOf("") }
        var textstate2 by remember { mutableStateOf("") }
        var textstate3 by remember { mutableStateOf("") }
        var textstate4 by remember { mutableStateOf("") }

        Surface (
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
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
                        painter = painterResource(id = R.drawable.forma_registrar_se),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    )

                    Column (
                        modifier = Modifier
                            .width(320.dp)
                            .height(570.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            color = Color.White,
                            text = stringResource(id = R.string.texto_registrar_se).uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp
                        )

                        OutlinedTextField(
                            value = textstate2,
                            onValueChange = { textstate = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.nome_label), fontSize = 15.sp, color = Color(
                                65,
                                57,
                                70,
                                204
                            )
                            )},
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )

                        OutlinedTextField(
                            value = textstate2,
                            onValueChange = { textstate2 = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.email_label), fontSize = 15.sp, color = Color(
                                65,
                                57,
                                70,
                                204
                            )
                            )},
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )

                        OutlinedTextField(
                            value = textstate2,
                            onValueChange = { textstate3 = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.senha_label), fontSize = 15.sp, color = Color(
                                65,
                                57,
                                70,
                                204
                            )
                            )},
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )

                        OutlinedTextField(
                            value = textstate2,
                            onValueChange = { textstate4 = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.repeticao_senha_label), fontSize = 15.sp, color = Color(
                                65,
                                57,
                                70,
                                204
                            )
                            )},
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )

                        Line()

                        WhiteButton(onClick = {  }, text = stringResource(id = R.string.texto_botao_login).uppercase())

                        GradientButton(
                            onClick = {  },
                            text = stringResource(id = R.string.texto_botao_registrar).uppercase(),
                            color1 = Destaque1,
                            color2 = Destaque2
                        )
                    }
                }
            }
        }
    }
}
