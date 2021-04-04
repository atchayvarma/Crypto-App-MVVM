package com.tamilanapps.cryptoapp.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tamilanapps.cryptoapp.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
val typography = Typography(


    h1 = TextStyle(
        fontFamily = Montserrat,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
)