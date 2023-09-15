package br.senai.sp.jandira.costurie_app.screens.tradePassword

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.Principal2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TradePasswordScreen() {
    var passwordState by remember {
        mutableStateOf("")
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forma_topo_recuperar_a_senha),
                    contentDescription = "",
                    modifier = Modifier
                        .width(177.dp)
                        .height(272.dp),
                    alignment = Alignment.TopStart

                )
                Image(
                    painter = painterResource(id = R.drawable.forma_baixo_recuperar_a_senha),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.BottomEnd
                )
                Box (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.modal_validar_codigo2),
                        contentDescription = "",
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(100.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            Column(Modifier.padding(end = 300.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.arrow_back),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(35.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(
                            modifier = Modifier.height(480.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                color = Color.White,
                                text = stringResource(R.string.troca_de_senha).uppercase(),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp
                            )
                            Column (
                                modifier = Modifier.height(300.dp),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                OutlinedTextField(
                                    value = passwordState,
                                    onValueChange = { passwordState = it},
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .height(60.dp),
                                    label = {
                                        Text(stringResource(id = R.string.senha_label),
                                            fontSize = 16.sp,
                                            textAlign = TextAlign.Center,
                                            color = Contraste2
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        unfocusedLabelColor = Color.Black,
                                        cursorColor = Color.Black,
                                        focusedLabelColor = Color.Black,
                                        textColor = Color.Black,
                                        containerColor = Principal2,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent
                                    ),
                                    textStyle = TextStyle.Default.copy(fontSize = 15.sp)
                                )
                                OutlinedTextField(
                                    value = passwordState,
                                    onValueChange = { passwordState = it},
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .height(60.dp),
                                    label = {
                                        Text(stringResource(id = R.string.repeticao_senha_label),
                                            fontSize = 16.sp,
                                            textAlign = TextAlign.Center,
                                            color = Contraste2
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        unfocusedLabelColor = Color.Black,
                                        cursorColor = Color.Black,
                                        focusedLabelColor = Color.Black,
                                        textColor = Color.Black,
                                        containerColor = Principal2,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent
                                    ),
                                    textStyle = TextStyle.Default.copy(fontSize = 15.sp)
                                )
                                Box(
                                    modifier = Modifier
                                        .width(320.dp)
                                        .height(80.dp)
                                        .background(Color.White)
                                        .shadow(1.dp)
                                ) {
                                    Column() {
                                        Text(
                                            text = stringResource(id = R.string.requerimentos_senha),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                        Text(
                                            text = stringResource(id = R.string.requerimentos_senha2),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = stringResource(id = R.string.requerimentos_senha3),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = stringResource(id = R.string.requerimentos_senha4),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                        Text(
                                            text = stringResource(id = R.string.requerimentos_senha5),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                    }

                                }
                            }
                            GradientButton(
                                onClick = { /*TODO*/ },
                                text = stringResource(id = R.string.texto_botao_confirmar),
                                color1 = Destaque1,
                                color2 = Destaque2
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TradePasswordScreenPreview() {
    TradePasswordScreen()
}