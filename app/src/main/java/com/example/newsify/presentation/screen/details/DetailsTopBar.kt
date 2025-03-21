package com.example.newsify.presentation.screen.details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.newsify.R
import com.example.newsify.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar (
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onBackClick: () -> Unit,
    @DrawableRes iconBookmark: Int = R.drawable.icon_bookmark,
) {
    TopAppBar (
        title = { },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors (
            containerColor = Color.Transparent,
            actionIconContentColor = SecondaryColor,
            navigationIconContentColor = SecondaryColor
        ),
        navigationIcon = {
            IconButton (
                onClick = onBackClick
            ) {
                Icon (
                    painter = painterResource(id = R.drawable.icon_arrow_back),
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton (
                onClick = onBookmarkClick
            ) {
                Icon (
                    painter = painterResource(iconBookmark),
                    contentDescription = null
                )
            }
            IconButton (
                onClick = onShareClick
            ) {
                Icon (
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
            IconButton (
                onClick = onBrowsingClick
            ) {
                Icon (
                    painter = painterResource(id = R.drawable.icon_network),
                    contentDescription = null
                )
            }
        }
    )
}