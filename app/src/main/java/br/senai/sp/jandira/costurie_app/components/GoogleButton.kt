package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import br.senai.sp.jandira.costurie_app.R


@Composable
fun GoogleButton(
    onClick: () -> Unit,
    text: String,
    icon: String,
) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .height(45.dp)
                .width(250.dp)
                .fillMaxWidth(),
            shape = ShapeButton.large,
            border = BorderStroke(2.dp, color = Destaque1),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Icon(
//                    imageVector = icon,
//                    contentDescription = null, // Defina uma descrição apropriada
//                    modifier = Modifier.size(24.dp), // Ajuste o tamanho do ícone conforme necessário
//                    tint = Color.White // Defina a cor do ícone conforme necessário
//                )
                Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre o ícone e o texto
                Text(
                    text = text,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
}


@Preview(showBackground = true)
@Composable
fun GoogleButtonPreview() {
    GoogleButton( onClick = {}, text = "", icon = "")
}