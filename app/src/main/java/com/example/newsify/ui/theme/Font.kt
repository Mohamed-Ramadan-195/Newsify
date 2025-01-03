package com.example.newsify.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import com.example.newsify.R

val Poppins = FontFamily (
    fonts = listOf (
        Font(
            resId = R.font.poppins_regular,
            weight = Normal
        ),
        Font(
            resId = R.font.poppins_semibold,
            weight = SemiBold
        ),
        Font(
            resId = R.font.poppins_bold,
            weight = Bold
        )
    )
)