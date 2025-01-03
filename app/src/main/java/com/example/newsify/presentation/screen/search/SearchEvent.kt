package com.example.newsify.presentation.screen.search

sealed class SearchEvent {

    data class UpdateSearchQuery (
        val searchQuery: String
    ) : SearchEvent()

    data object SearchNews: SearchEvent()

}