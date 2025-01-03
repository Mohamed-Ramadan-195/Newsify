package com.example.newsify.presentation.screen.bookmark

import com.example.newsify.domain.model.Article

data class BookmarkState (
    val articles: List<Article> = emptyList()
)