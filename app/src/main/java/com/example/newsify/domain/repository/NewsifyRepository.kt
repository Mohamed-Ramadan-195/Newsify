package com.example.newsify.domain.repository

import androidx.paging.PagingData
import com.example.newsify.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsifyRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews (
        searchQuery: String,
        sources: List<String>
    ) : Flow<PagingData<Article>>

    suspend fun insertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun selectArticles(): Flow<List<Article>>

    suspend fun selectArticle(url: String): Article?

}