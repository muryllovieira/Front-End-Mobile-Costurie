package br.senai.sp.jandira.costurie_app.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.components.Line
import br.senai.sp.jandira.costurie_app.components.WhiteButton
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    Costurie_appTheme {

        var nameState by remember  {
            mutableStateOf("")
        }

        var emailState by remember {
            mutableStateOf("")
        }

        var passwordState by remember {
            mutableStateOf("")
        }

        var repeatPasswordState by remember {
            mutableStateOf("")
        }

        var passwordVisibilityState by remember {
            mutableStateOf(false)
        }

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
                            value = nameState,
                            onValueChange = { nameState = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .width(280.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.nome_label), fontSize = 15.sp, color = Contraste2) },
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp),
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.question_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = Color(65, 57, 70, 255)
                                )
                            }
                        )

                        OutlinedTextField(
                            value = emailState,
                            onValueChange = { emailState = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.email_label), fontSize = 15.sp, color = Contraste2) },
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
                            value = passwordState,
                            onValueChange = { passwordState = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .width(280.dp)
                                .height(62.dp),
                            shape = RoundedCornerShape(20.dp),
                            visualTransformation = if (!passwordVisibilityState) PasswordVisualTransformation()
                            else
                                VisualTransformation.None,
                            label = { Text(stringResource(id = R.string.senha_label), fontSize = 15.sp, color = Contraste2) },
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibilityState = !passwordVisibilityState
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (passwordVisibilityState)
                                            Icons.Default.VisibilityOff
                                        else
                                            Icons.Default.Visibility,
                                        contentDescription = null
                                    )
                                }
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedLabelColor = Color.Black,
                                cursorColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                textColor = Color.Black,
                                containerColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                        )

                        OutlinedTextField(
                            value = repeatPasswordState,
                            onValueChange = { repeatPasswordState = it },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .height(62.dp),
                            label = { Text(stringResource(id = R.string.repeticao_senha_label), fontSize = 15.sp, color = Contraste2) },
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

                        GradientButton(
                            onClick = {  },
                            text = stringResource(id = R.string.texto_botao_registrar).uppercase(),
                            color1 = Destaque1,
                            color2 = Destaque2
                        )

                        Line()

                        WhiteButton(onClick = {  }, text = stringResource(id = R.string.texto_botao_login).uppercase())
                    }
                }
            }
        }
    }
}