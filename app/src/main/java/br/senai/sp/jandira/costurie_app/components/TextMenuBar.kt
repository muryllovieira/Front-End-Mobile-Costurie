package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque1
import br.senai.sp.jandira.costurie_app.ui.theme.Destaque2

@OptIn(ExperimentalTextApi::class)
@Composable
fun TextMenuBar (text: String) {

    val brush = Brush.horizontalGradient(listOf(Destaque1, Destaque2))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text,
            modifier = Modifier
                .padding(bottom = 6.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Destaque1,
                        Destaque2
                    ),
                    tileMode = TileMode.Mirror
                )
            )

        )
        Canvas(
            modifier = Modifier.size(5.dp),
            onDraw = {
                drawCircle(
                    brush = brush
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextMenuBar () {
    TextMenuBar("teste")
}