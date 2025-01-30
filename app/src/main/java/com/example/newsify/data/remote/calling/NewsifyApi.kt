package com.example.newsify.data.remote.calling

import com.example.newsify.data.remote.dto.NewsifyResponse
import com.example.newsify.util.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsifyApi {

    @GET("everything")
    suspend fun getNews (
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsifyResponse

    @GET("everything")
    suspend fun searchNews (
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsifyResponse

}