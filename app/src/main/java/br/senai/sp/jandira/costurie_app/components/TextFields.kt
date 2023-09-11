package br.senai.sp.jandira.costurie_app.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeTexto(
    label: String,
    valor: String,
    aoMudar: (String) -> Unit
) {
    OutlinedTextField(
        value = valor,
        onValueChange = {
            aoMudar(it)
        },
        modifier = Modifier.height(30.dp).fillMaxWidth(),
        label = {
            Text(text = label)
        },

    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CaixaDeTextoPreview() {
    //CaixaDeTexto("teste", "")
}