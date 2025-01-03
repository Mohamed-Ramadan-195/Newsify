package com.example.newsify.domain.usecase.newsify.local

import com.example.newsify.domain.model.Article
import com.example.newsify.domain.repository.NewsifyRepository
import kotlinx.coroutines.flow.Flow

class SelectArticlesUseCase (
    private val newsifyRepository: NewsifyRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsifyRepository.selectArticles()
    }
}