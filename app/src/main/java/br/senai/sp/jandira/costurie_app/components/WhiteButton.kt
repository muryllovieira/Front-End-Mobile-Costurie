package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton

@Composable
fun WhiteButton (
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick,
        modifier = Modifier
            .height(45.dp)
            .width(225.dp)
            .fillMaxWidth(),
        shape = ShapeButton.large,
        border = BorderStroke(
            2.dp, Color(168, 155, 255, 255)
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
    ) {
        Text(text = text, fontSize = 18.sp, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = Color(
            168,
            155,
            255,
            255
        )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WhiteButtonPreview() {
    WhiteButton(onClick = {  }, text = "",)
}