package com.example.newsify.util

object Constant {
    // Basics
    const val EMPTY_STRING = ""

    // App Entry
    const val USER_SETTINGS = "userSettings"
    const val APP_ENTRY = "appEntry"

    // Remote Data
    const val API_KEY = "b8f309a20d6745399448c41fc8a94cd9"
    const val BASE_URL = "https://newsapi.org/v2/"

    // Local Data
    const val NEWSIFY_DATABASE_NAME = "newsifyDatabase"
    const val GET_NEWS_QUERY = "SELECT * FROM Article"
    const val SEARCH_NEWS_QUERY = "SELECT * FROM Article WHERE url=:url"

    // Screen
    const val ON_BOARDING_SCREEN = "onBoardingScreen"
    const val HOME_SCREEN = "homeScreen"
    const val SEARCH_SCREEN = "searchScreen"
    const val BOOKMARK_SCREEN = "bookmarkScreen"
    const val DETAILS_SCREEN = "detailsScreen"

    // Navigation
    const val APP_START_NAVIGATION = "appStartNavigation"
    const val NEWSIFY_NAVIGATION = "newsifyNavigation"
    const val NEWSIFY_NAVIGATOR_SCREEN = "newsifyNavigatorScreen"
}