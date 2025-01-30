package com.example.newsify.presentation.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsify.domain.usecase.app_entry.AppEntryUseCases
import com.example.newsify.presentation.onboarding.screen.OnBoardingEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor (
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {
    fun onEvent (
        onBoardingEvent: OnBoardingEvent
    ) {
        when(onBoardingEvent) {
            is OnBoardingEvent.SaveAppEntry -> { saveAppEntry() }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntryUseCase()
        }
    }
}