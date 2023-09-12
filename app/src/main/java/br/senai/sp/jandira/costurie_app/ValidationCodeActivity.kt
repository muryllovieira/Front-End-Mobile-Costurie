package br.senai.sp.jandira.costurie_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.costurie_app.ui.theme.Costurie_appTheme

class ValidationCodeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Costurie_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Costurie_appTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forma_topo_recuperar_a_senha),
                    contentDescription = "",
                    modifier = Modifier
                        .width(177.dp)
                        .height(272.dp),
                    alignment = Alignment.TopStart

                )
                Image(
                    painter = painterResource(id = R.drawable.forma_baixo_recuperar_a_senha),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.BottomEnd
                 )
                Box (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.modal_validar_codigo),
                        contentDescription = "",
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}