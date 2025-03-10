package com.example.newsify.presentation.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.composables.NewsifyList
import com.example.newsify.presentation.composables.NewsifySearchBar

@Composable
fun SearchScreen(
    navigateToDetails: (Article) -> Unit
) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    val searchState = searchViewModel.state.value

    SearchScreenContent(
        searchState = searchState,
        searchEvent = searchViewModel::onEvent,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun SearchScreenContent (
    searchState: SearchState,
    searchEvent: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .statusBarsPadding()
            .padding(16.dp)
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