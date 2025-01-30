package com.example.newsify.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsify.domain.usecase.newsify.NewsifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    newsifyUseCases: NewsifyUseCases
) : ViewModel() {

    val news = newsifyUseCases.getNewsUseCase (
        listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)

}