package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField2(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    borderColor: Color,
    modifier: Modifier
) {

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = modifier
                .background(
                    colorResource(id = R.color.principal_2),
                    shape = RoundedCornerShape(20.dp)
                ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
            ),
            label = { Text(label, fontSize = 15.sp, color = Contraste2) },
            textStyle = TextStyle.Default.copy(fontSize = 18.sp, color = Color.Black),
            //singleLine = true
        )



}

