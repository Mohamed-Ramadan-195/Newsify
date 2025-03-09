package com.example.newsify.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsify.util.shimmerEffect

@Composable
fun NewsifyCardShimmerEffect(
    modifier: Modifier = Modifier
) {
    Row (
        modifier = Modifier
    ) {
        Box (
            modifier = Modifier
                .size(96.dp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(96.dp)
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = 24.dp)
                    .shimmerEffect()
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .padding(horizontal = 24.dp)
                        .shimmerEffect()
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NewsifyCardShimmerEffectPreview() {
    NewsifyCardShimmerEffect()
}