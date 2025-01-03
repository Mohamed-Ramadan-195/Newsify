package com.example.newsify.presentation.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R

@Composable
fun NewsifyButton (
    text: String,
    onClick: () -> Unit
) {
    Button (
        onClick = onClick,
        shape = RoundedCornerShape(size = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )
    ) {
        Text (
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun NewsifyTextButton (
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text (
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.secondary_text)
        )
    }
}