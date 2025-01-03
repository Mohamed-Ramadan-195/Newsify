package com.example.newsify.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.newsify.domain.model.Article
import com.example.newsify.util.Constant.GET_NEWS_QUERY
import com.example.newsify.util.Constant.SEARCH_NEWS_QUERY
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsifyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query(GET_NEWS_QUERY)
    fun selectArticles(): Flow<List<Article>>

    @Query(SEARCH_NEWS_QUERY)
    suspend fun selectArticle(url: String): Article?

}