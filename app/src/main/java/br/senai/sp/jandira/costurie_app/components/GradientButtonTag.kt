package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@Composable
fun GradientButtonTag(
    onClick: () -> Unit,
    text: String,
    color1: Color,
    color2: Color,
    textColor: Color
) {
    val brush = Brush.horizontalGradient(listOf(Destaque1, Destaque2))
        Button(
            onClick = onClick,
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            color1,
                            color2
                        )
                    ),
                    shape = RoundedCornerShape(15.dp),
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                hoveredElevation = 0.dp
            ),
            border = BorderStroke(2.dp, brush),
            contentPadding = PaddingValues.Absolute(top = 5.dp, right = 11.dp, bottom = 5.dp, left = 11.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                text = text,
                fontSize = 14.sp,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = textColor
            )


        }

}

@Preview(showBackground = true)
@Composable
fun GradientButtonTagPreview() {
    GradientButtonTag(onClick = { }, text = "teste", color1 = Destaque1, color2 = Destaque2, textColor = Color.Black)
}