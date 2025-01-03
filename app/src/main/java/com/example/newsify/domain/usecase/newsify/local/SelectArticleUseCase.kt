package com.example.newsify.domain.usecase.newsify.local

import com.example.newsify.domain.model.Article
import com.example.newsify.domain.repository.NewsifyRepository

class SelectArticleUseCase (
    private val newsifyRepository: NewsifyRepository
) {
    suspend operator fun invoke (url: String): Article? {
        return newsifyRepository.selectArticle(url = url)
    }
}