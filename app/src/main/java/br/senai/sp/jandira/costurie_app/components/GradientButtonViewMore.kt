package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton

@Composable
fun GradientButtonViewMore (
    onClick: () -> Unit,
    color1: Color,
    color2: Color
) {
    Button(
        onClick,
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        color1,
                        color2
                    )
                ),
                shape = ShapeButton.large,
            )
            .height(37.dp)
            .width(115.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp
        )
    ) {
        Text(
            text = stringResource(id = R.string.texto_button_tag),
            fontSize = 11.sp,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GradientButtonViewMorePreview() {
    GradientButtonViewMore(onClick = {  },color1 = Destaque1, color2 = Destaque2)
}