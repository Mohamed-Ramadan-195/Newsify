package com.example.newsify.presentation.screen.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsify.domain.usecase.newsify.NewsifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsifyUseCases: NewsifyUseCases
) : ViewModel() {
    private var _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticlesBookmarked()
    }

    private fun getArticlesBookmarked() {
        newsifyUseCases.selectArticlesUseCase().onEach {
            _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)
    }
}