package com.example.newsify.domain.usecase.newsify

import com.example.newsify.domain.usecase.newsify.local.DeleteNewsUseCase
import com.example.newsify.domain.usecase.newsify.local.InsertArticleUseCase
import com.example.newsify.domain.usecase.newsify.local.SelectArticleUseCase
import com.example.newsify.domain.usecase.newsify.local.SelectArticlesUseCase
import com.example.newsify.domain.usecase.newsify.remote.GetNewsUseCase
import com.example.newsify.domain.usecase.newsify.remote.SearchNewsUseCase

data class NewsifyUseCases (
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val insertArticleUseCase: InsertArticleUseCase,
    val deleteNewsUseCase: DeleteNewsUseCase,
    val selectArticleUseCase: SelectArticleUseCase,
    val selectArticlesUseCase: SelectArticlesUseCase
)