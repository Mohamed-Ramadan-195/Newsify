package com.example.newsify.presentation.onboarding.screen

sealed class OnBoardingEvent {
    data object SaveAppEntry: OnBoardingEvent()
}