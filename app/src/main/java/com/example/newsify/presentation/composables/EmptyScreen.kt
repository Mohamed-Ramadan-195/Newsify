package com.example.newsify.presentation.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.example.newsify.R
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null
) {

    var message by remember {
        mutableStateOf(parseErrorMessage(error = error))
    }

    var icon by remember {
        mutableIntStateOf(R.drawable.network_error)
    }

    if (error == null) {
        message = stringResource(R.string.empty_news)
        icon = R.drawable.content_search
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation by animateFloatAsState (
        targetValue = if (startAnimation) 0.3f else 0f,
        animationSpec = tween(durationMillis = 1500),
        label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent (
        alphaAnimation = alphaAnimation,
        message = message,
        iconId = icon
    )
}

@Composable
fun EmptyContent(
    alphaAnimation: Float,
    message: String,
    iconId: Int
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon (
            painter = painterResource(iconId),
            contentDescription = null,
            // tint = if (isSystemInDarkTheme())
            modifier = Modifier
                .size(120.dp)
                .alpha(alphaAnimation)
        )
        Text (
            text = message,
            modifier = Modifier
                .padding(10.dp)
                .alpha(alphaAnimation),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            // color = if (isSystemInDarkTheme())
        )
    }
}

fun parseErrorMessage(error: LoadState.Error?): String {
    return when (error?.error) {
        is SocketTimeoutException -> {
            "Server Unavailable."
        }

        is ConnectException -> {
            "Internet Unavailable."
        }

        else -> {
            "Unknown Error."
        }
    }
}