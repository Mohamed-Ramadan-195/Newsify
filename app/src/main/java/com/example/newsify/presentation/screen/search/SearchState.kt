package com.example.newsify.presentation.screen.search

import androidx.paging.PagingData
import com.example.newsify.domain.model.Article
import com.example.newsify.util.Constant.EMPTY_STRING
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = EMPTY_STRING,
    val articles: Flow<PagingData<Article>>? = null
)