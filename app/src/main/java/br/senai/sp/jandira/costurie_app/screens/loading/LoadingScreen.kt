package br.senai.sp.jandira.costurie_app.screens.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import br.senai.sp.jandira.costurie_app.R

@Composable
fun LoadingScreen(navController: NavController, lifecycleScope: LifecycleCoroutineScope) {
    val gradient = Brush.linearGradient(
        0.2f to Color(201, 143, 236, 255),
        1.0f to Color(168, 155, 255, 255),
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier.background(gradient),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.line_loading),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 40.dp),
            alignment = Alignment.TopCenter
        )

        Image(
            painter = painterResource(id = R.drawable.line_loading),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            alignment = Alignment.BottomEnd
        )

        Column {
            Image(
                painter = painterResource(id = R.drawable.logo_costurie),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                alignment = Alignment.Center
            )
            Text(
                color = Color.White,
                text = stringResource(id = R.string.titulo_app).uppercase(),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.bodyLarge,
                letterSpacing = 4.sp,
                fontSize = 32.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}