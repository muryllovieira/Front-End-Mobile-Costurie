
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.components.GoogleButton
import br.senai.sp.jandira.costurie_app.components.GradientButton
import br.senai.sp.jandira.costurie_app.components.WhiteButton
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2


@Composable
fun ProfileScreen() {
    val context = LocalContext.current

    Costurie_appTheme {

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
                        painter = painterResource(id = R.drawable.forma_tela_perfil),
                        contentDescription = "",
                        modifier = Modifier
                            .height(240.dp)
                            .width(390.dp),
                        alignment = Alignment.TopStart
                    )

                    Column () {
                        Row (
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                                .fillMaxWidth(),
                            Arrangement.SpaceBetween
                        ){
                            Text(
                                color = Color.White,
                                text = stringResource(id = R.string.texto_meu_perfil),
                                style = MaterialTheme.typography.bodySmall,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Row (
                                modifier = Modifier
                                    .padding(end = 16.dp)
                                    .width(280.dp),
                                Arrangement.End
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_edit),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(35.dp),
                                    alignment = Alignment.TopEnd
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.icon_config),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(35.dp)
                                )
                            }
                        }

                        Row (
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .width(320.dp),
                            Arrangement.Start
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile_pic),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(88.dp)
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Column (
                            ) {
                                Text(
                                    color = Color.White,
                                    text = stringResource(id = R.string.nome_perfil),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.height(24.dp)
                                )

                                Text(
                                    color = Color.White,
                                    text = stringResource(id = R.string.tag_usuario),
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.height(22.dp)
                                )

                                Row {
                                    Image(
                                        painter = painterResource(id = R.drawable.icon_location),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(22.dp)
                                    )

                                    Text(
                                        color = Color.White,
                                        text = stringResource(id = R.string.cidade_perfil),
                                        style = MaterialTheme.typography.bodySmall,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium,
                                        modifier = Modifier.height(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                Row (
                    modifier = Modifier
                        .height(480.dp)
                ){

                    Spacer(modifier = Modifier.height(40.dp))

                    WhiteButton(
                        onClick = { },
                        text = stringResource(id = R.string.botao_recomendacoes).uppercase()
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    WhiteButton(
                        onClick = {},
                        text = stringResource(id = R.string.botao_recomendados).uppercase()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}