package br.senai.sp.jandira.costurie_app.screens.personalization

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.CustomOutlinedTextField2
import br.senai.sp.jandira.costurie_app.components.GradientButtonTag
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileTypeScreen(
    viewModel: UserViewModel,
    isSelected: Boolean
) {

    val brush = Brush.horizontalGradient(listOf(Destaque1, Destaque2))
    var pesquisaState by remember {
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
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
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "",
                            modifier = Modifier
                                .size(45.dp)
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
                }//row
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 35.dp, vertical = 56.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(

                        text = stringResource(id = R.string.texto_tag_de_servico).uppercase(),
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text( text = stringResource(id = R.string.descricao_tag_de_servico),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "geral".uppercase(),
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp,
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "roupas".uppercase(),
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp,
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "acessórios".uppercase(),
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp,
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "ajustes".uppercase(),
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp,
                            fontSize = 10.sp,
                            color = Color.Black
                        )

                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    CustomOutlinedTextField2(
                        value = pesquisaState,
                        onValueChange = {
                            pesquisaState = it
                        },
                        label = stringResource(id = R.string.tag_de_servico_label),
                        borderColor = Color.Transparent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    FlowRow(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        maxItemsInEachRow = 3
                    ) {
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                        GradientButtonTag(
                            onClick = { /*TODO*/ },
                            text = "crochê",
                            color1 = Destaque1,
                            color2 = Destaque2,
                            viewModel,
                        )
                    }

                }
            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun PreviewProfileTypeScreen() {
//    ProfileTypeScreen()
//}