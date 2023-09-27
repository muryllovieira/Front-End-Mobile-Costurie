package br.senai.sp.jandira.costurie_app.screens.personalization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.DropdownBairro
import br.senai.sp.jandira.costurie_app.components.DropdownCidade
import br.senai.sp.jandira.costurie_app.components.DropdownEstado
import br.senai.sp.jandira.costurie_app.components.WhiteButton
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen() {

    val brush = Brush.horizontalGradient(listOf(Destaque1, Destaque2))
    var descriptionState by remember {
        mutableStateOf("")
    }

    Costurie_appTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                //horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = { /*TODO*/ },

                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "",
                            modifier = Modifier
                                .size(35.dp),
                            tint = Color.Magenta
                        )
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(45.dp)
                            .background(
                                brush = brush,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            hoveredElevation = 0.dp
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_forward),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.White
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp, vertical = 56.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(

                        text = stringResource(id = R.string.texto_localizacao_do_seu_perfil).uppercase(),
                        modifier = Modifier.height(30.dp),
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    //Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text =
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black)) {
                                append(stringResource(id = R.string.descricao_localizacao_do_seu_perfil1))
                            }
                            append(" ")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(stringResource(id = R.string.descricao_localizacao_do_seu_perfil2))
                            }
                        },
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

                Text(
                    modifier = Modifier.padding(15.dp, 0.dp, 15.dp, 0.dp),
                    text = stringResource(id = R.string.texto_adicionar_localizacao),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

                //Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "Estados:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
                )
                DropdownEstado()
                Text(
                    text = "Cidades:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
                )
                DropdownCidade()
                Text(
                    text = "Bairros:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
                )
                DropdownBairro()

                Column(
                    modifier = Modifier.fillMaxWidth().padding(0.dp, 25.dp, 0.dp, 0.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    WhiteButton(
                        onClick = { /*TODO*/ },
                        text = "Pular".uppercase()
                    )
                }

            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewLocationScreen() {
    LocationScreen()
}