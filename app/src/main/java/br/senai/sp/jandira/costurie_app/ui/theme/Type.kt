package br.senai.sp.jandira.costurie_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.costurie_app.R

val Kufam = FontFamily(
    Font(R.font.kufam_regular),
    Font(R.font.kufam_medium, FontWeight.Medium),
    Font(R.font.kufam_bold, FontWeight.Bold),
    Font(R.font.kufam_semibold, FontWeight.SemiBold),
    Font(R.font.kufam_extrabold, FontWeight.ExtraBold),
)

val Typography = Typography(
    bodySmall = TextStyle (
        fontFamily = Kufam,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle (
        fontFamily = Kufam,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    bodyLarge = TextStyle (
        fontFamily = Kufam,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
)
