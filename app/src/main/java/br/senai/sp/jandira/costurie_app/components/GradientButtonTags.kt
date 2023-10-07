package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.model.TagsResponse
import br.senai.sp.jandira.costurie_app.ui.theme.ShapeButton
import br.senai.sp.jandira.costurie_app.viewModel.TagsViewModel
import br.senai.sp.jandira.costurie_app.viewModel.UserViewModel

@Composable
fun GradientButtonTags(
    onClick: () -> Unit,
    text: String,
    color1: Color,
    color2: Color
) {
    var isClicked by remember { mutableStateOf(false) }

    val backgroundColor = if (isClicked) Color.White else color1
    Button(
        onClick = {
            isClicked = !isClicked
            onClick()
        },
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        backgroundColor,
                        color2
                    )
                ),
                shape = ShapeButton.large,
            )
            .height(37.dp)
            .width(230.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp
        ),
        border = BorderStroke(
            2.dp, Color(168, 155, 255, 255)
        )
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
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