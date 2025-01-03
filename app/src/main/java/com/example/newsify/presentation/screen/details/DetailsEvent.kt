package com.example.newsify.presentation.screen.details

import com.example.newsify.domain.model.Article

sealed class DetailsEvent {

    data class InsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect: DetailsEvent()

}