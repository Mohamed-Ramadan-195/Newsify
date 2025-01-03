package com.example.newsify.presentation.navgraph.bottom_navigation

import androidx.annotation.DrawableRes

data class BottomNavigationItem (
    @DrawableRes val icon: Int,
    val text: String
)