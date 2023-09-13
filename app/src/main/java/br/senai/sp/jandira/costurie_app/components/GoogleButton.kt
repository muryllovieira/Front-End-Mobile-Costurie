package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2


@Composable
fun GoogleButton(
    onClick: () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        Surface(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.destaque_1),
                    shape = ShapeButton.large
                )
                .width(225.dp)
                .height(45.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(22.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {


                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(24.dp)
                )



//                Icon(
//                    imageVector = icon,
//                    contentDescription = null, // Defina uma descrição apropriada
//                    modifier = Modifier.size(24.dp), // Ajuste o tamanho do ícone conforme necessário
//                    tint = Color.White // Defina a cor do ícone conforme necessário
//                )
                Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre o ícone e o texto

                Text(
                    text = text,
                    style =
                        MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = colorResource(id = R.color.destaque_1)


                )
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun GoogleButtonPreview() {
    GoogleButton(onClick = {  }, text = "")
}