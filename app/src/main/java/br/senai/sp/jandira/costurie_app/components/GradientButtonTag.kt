package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@Composable
fun GradientButtonTag(
    onClick: () -> Unit,
    text: String,
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
                .width(IntrinsicSize.Min),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                hoveredElevation = 0.dp
            ),
            //contentPadding = PaddingValues.Absolute(12.dp)
        ) {

            Text(
                text = text,
                fontSize = 14.sp,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold
            )


        }

}

//@Preview(showBackground = true)
//@Composable
//fun GradientButtonTagPreview() {
//    GradientButtonTag(onClick = { }, text = "", color1 = Destaque1, color2 = Destaque2)
//}