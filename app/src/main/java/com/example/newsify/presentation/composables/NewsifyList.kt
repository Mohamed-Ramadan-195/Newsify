package com.example.newsify.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsify.domain.model.Article

@Composable
fun NewsifyList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick: (Article) -> Unit     // for details screen
) {
    if (articles.isEmpty()) { EmptyScreen() }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        contentPadding = PaddingValues(all = 6.dp)
    ) {
        items(count = articles.size) {
            val article = articles[it]
            NewsifyCard(
                article = article,
                onClick = { onClick(article) }
            )
        }
    }
}

@Composable
fun NewsifyList (
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            contentPadding = PaddingValues(all = 6.dp)
        ) {
            items(count = articles.itemCount) {
                articles[it]?.let {
                    NewsifyCard(
                        article = it,
                        onClick = { onClick(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult (
    articles: LazyPagingItems<Article>
) : Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        articles.itemCount == 0 -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        repeat(10) {
            NewsifyCardShimmerEffect(
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}