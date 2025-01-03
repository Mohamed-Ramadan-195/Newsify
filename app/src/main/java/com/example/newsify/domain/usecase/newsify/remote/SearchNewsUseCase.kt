package com.example.newsify.domain.usecase.newsify.remote

import androidx.paging.PagingData
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.repository.NewsifyRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCase (
    private val newsifyRepository: NewsifyRepository
) {
    operator fun invoke (
        searchQuery: String,
        sources: List<String>
    ) : Flow<PagingData<Article>> {
        return newsifyRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}