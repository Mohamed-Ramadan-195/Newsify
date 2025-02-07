package com.example.newsify.presentation.navigation.navgraph

import com.example.newsify.util.Constant.APP_START_NAVIGATION
import com.example.newsify.util.Constant.HOME_SCREEN
import com.example.newsify.util.Constant.SEARCH_SCREEN
import com.example.newsify.util.Constant.BOOKMARK_SCREEN
import com.example.newsify.util.Constant.DETAILS_SCREEN
import com.example.newsify.util.Constant.NEWSIFY_NAVIGATION
import com.example.newsify.util.Constant.NEWSIFY_NAVIGATOR_SCREEN
import com.example.newsify.util.Constant.ON_BOARDING_SCREEN

sealed class Route (
    val route: String
) {
    data object OnBoardingScreen: Route(route = ON_BOARDING_SCREEN)

    data object HomeScreen: Route(route = HOME_SCREEN)
    data object SearchScreen: Route(route = SEARCH_SCREEN)
    data object BookmarkScreen: Route(route = BOOKMARK_SCREEN)
    data object DetailsScreen: Route(route = DETAILS_SCREEN)

    data object AppStartNavigation: Route(route = APP_START_NAVIGATION)
    data object NewsifyNavigation: Route(route = NEWSIFY_NAVIGATION)
    data object NewsifyNavigatorScreen : Route(route = NEWSIFY_NAVIGATOR_SCREEN)
}