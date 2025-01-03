package com.example.newsify.domain.usecase.newsify.local

import com.example.newsify.domain.model.Article
import com.example.newsify.domain.repository.NewsifyRepository

class InsertArticleUseCase (
    private val newsifyRepository: NewsifyRepository
) {
    suspend operator fun invoke(article: Article) {
        newsifyRepository.insertArticle(article = article)
    }
}