package com.example.newsify.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.newsify.presentation.Dimen.UnderMediumSpace
import com.example.newsify.ui.theme.Gray

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = Gray
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat (times = pageCount) { page ->
            Box (
                modifier = Modifier
                    .size(UnderMediumSpace)
                    .clip(CircleShape)
                    .background (
                        if (page == selectedPage) selectedColor
                        else unSelectedColor
                    )
            )
        }
    }
}