package com.example.newsify.presentation.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.composables.NewsifyList
import com.example.newsify.presentation.composables.NewsifySearchBar

@Composable
fun SearchScreen (
    searchState: SearchState,
    searchEvent: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column (
        modifier = Modifier
            .padding (
                start = 24.dp,
                end = 24.dp,
                top = 24.dp
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        NewsifySearchBar (
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = { searchEvent(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { searchEvent(SearchEvent.SearchNews) }
        )
        Spacer(modifier = Modifier.padding(24.dp))
        searchState.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            NewsifyList (
                articles = articles,
                onClick = { navigateToDetails(it) }
            )
        }
    }
}