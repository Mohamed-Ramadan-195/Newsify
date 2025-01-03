package com.example.newsify.util

import android.content.Context
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsify.R
import com.example.newsify.util.Constant.USER_SETTINGS

fun Modifier.searchBarBorder() = composed {
    if (!isSystemInDarkTheme()) {
        border (
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium
        )
    } else {
        this
    }
}

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat (
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable (
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    background(color = colorResource(R.color.secondary_text).copy(alpha = alpha))
}