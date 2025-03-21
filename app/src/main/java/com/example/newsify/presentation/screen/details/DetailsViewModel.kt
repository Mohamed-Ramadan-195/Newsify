package com.example.newsify.presentation.screen.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.usecase.newsify.NewsifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsifyUseCases: NewsifyUseCases
) : ViewModel() {
    var sideEffect by mutableStateOf<String?>(null)
        private set

    var bookmarkedArticles by mutableStateOf(setOf<String>())
        private set

    fun onEvent(detailsEvent: DetailsEvent) {
        when (detailsEvent) {
            is DetailsEvent.InsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsifyUseCases.selectArticleUseCase(detailsEvent.article.url)
                    if (article == null) {
                        upsertArticle(detailsEvent.article)
                    } else {
                        deleteArticle(detailsEvent.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun upsertArticle(article: Article) {
        newsifyUseCases.insertArticleUseCase(article = article)
        bookmarkedArticles += article.url
        sideEffect = "Article Saved"
    }

    private suspend fun deleteArticle(article: Article) {
        newsifyUseCases.deleteNewsUseCase(article = article)
        bookmarkedArticles -= article.url
        sideEffect = "Article Deleted"
    }
}