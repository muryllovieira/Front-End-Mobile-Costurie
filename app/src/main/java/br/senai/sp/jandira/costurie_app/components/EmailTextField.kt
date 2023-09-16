package br.senai.sp.jandira.costurie_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.ui.theme.Contraste2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    leadingIconImageVector: ImageVector,
    leadingIconDescription: String = "",
    isPasswordField: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    showError: Boolean = false,
    errorMessage: String = ""
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .padding(top = 20.dp)
                .width(400.dp)
                .height(62.dp),
            label = { Text(label, fontSize = 15.sp, color = Contraste2) },
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle.Default.copy(fontSize = 15.sp),
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint = if (showError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            },
            isError = showError,
            trailingIcon = {
                if (showError && !isPasswordField) Icon(imageVector = Icons.Filled.Error, contentDescription = "Icone de Erro")
                if (isPasswordField) {
                    IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Visualização da Senha"
                        )
                    }
                }
            },
            visualTransformation = when {
                isPasswordField && isPasswordVisible -> VisualTransformation.None
                isPasswordField -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .offset(y = (-8).dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}