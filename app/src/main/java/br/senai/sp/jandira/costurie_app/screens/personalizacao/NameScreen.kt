package br.senai.sp.jandira.costurie_app.screens.personalizacao

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameScreen() {

    val brush = Brush.horizontalGradient(listOf(Destaque1, Destaque2))
    var value by remember {
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
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    IconButton(onClick = { /*TODO*/ }) {
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
                            .size(30.dp)
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
                }//row
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 27.dp, vertical = 56.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(

                        text = stringResource(id = R.string.texto_nome_do_seu_perfil).uppercase(),
                        modifier = Modifier.height(30.dp),
                        style = MaterialTheme.typography.bodySmall,
                        letterSpacing = 2.sp,
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text( text =
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append(stringResource(id = R.string.descricao_nome_do_seu_perfil1))
                        }
                        append(" ")
                        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                            append(stringResource(id = R.string.descricao_nome_do_seu_perfil2))
                        }
                    },
                        fontSize = 12.sp
                    )
                }

                OutlinedTextField(
                    value = stringResource(id = R.string.nome_do_perfil_label),
                    onValueChange = {},
                    textStyle = TextStyle.Default.copy(fontSize = 12.sp),
                    modifier = Modifier.height(IntrinsicSize.Min),
                    shape = RoundedCornerShape(15.dp)
                )

            }

            }
        }
    }


@Preview(showSystemUi = true)
@Composable
fun PreviewNameScreen() {
    NameScreen()
}