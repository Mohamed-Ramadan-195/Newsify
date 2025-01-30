package com.example.newsify.data.remote.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsify.data.remote.calling.NewsifyApi
import com.example.newsify.domain.model.Article

class NewsifyPagingSource (
    private val newsifyApi: NewsifyApi,
    private val sources: String
) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsifyApi.getNews (
                sources = sources,
                page = page
            )
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page (
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            LoadResult.Error (
                throwable = exception
            )
        }
    }

}