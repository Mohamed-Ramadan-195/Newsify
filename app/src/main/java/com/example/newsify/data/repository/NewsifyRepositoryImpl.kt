package com.example.newsify.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsify.data.local.NewsifyDao
import com.example.newsify.data.remote.NewsifyApi
import com.example.newsify.data.remote.NewsifyPagingSource
import com.example.newsify.data.remote.SearchNewsifyPagingSource
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.repository.NewsifyRepository
import kotlinx.coroutines.flow.Flow

class NewsifyRepositoryImpl (
    private val newsifyApi: NewsifyApi,
    private val newsifyDao: NewsifyDao
) : NewsifyRepository {

    // getNews & searchNews -> Remote
    // insert, delete & select -> Local

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager (
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsifyPagingSource (
                    newsifyApi = newsifyApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager (
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsifyPagingSource (
                    newsifyApi = newsifyApi,
                    sources = sources.joinToString(separator = ","),
                    searchQuery = searchQuery
                )
            }
        ).flow
    }

    override suspend fun insertArticle(article: Article) = newsifyDao.insertArticle(article)

    override suspend fun deleteArticle(article: Article) = newsifyDao.deleteArticle(article)

    override fun selectArticles(): Flow<List<Article>> = newsifyDao.selectArticles()

    override suspend fun selectArticle(url: String): Article? = newsifyDao.selectArticle(url)
}