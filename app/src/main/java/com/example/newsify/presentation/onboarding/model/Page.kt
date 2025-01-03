package com.example.newsify.presentation.onboarding.model

import androidx.annotation.DrawableRes

data class Page (
    val title: String,
    val body: String,
    @DrawableRes val image: Int
)