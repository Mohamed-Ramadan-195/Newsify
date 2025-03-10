package com.example.newsify.presentation.navigation.navgraph

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsify.R
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.navigation.bottom_navigation.BottomNavigationItem
import com.example.newsify.presentation.navigation.bottom_navigation.NewsifyBottomNavigation
import com.example.newsify.presentation.screen.bookmark.BookmarkScreen
import com.example.newsify.presentation.screen.details.DetailsScreen
import com.example.newsify.presentation.screen.home.HomeScreen
import com.example.newsify.presentation.screen.search.SearchScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsifyNavigation() {
    val bottomNavigationItemData = remember {
        listOf(
            BottomNavigationItem (
                icon = R.drawable.icon_home,
                iconFocused = R.drawable.icon_home,
                text = "Home"
            ),
            BottomNavigationItem (
                icon = R.drawable.icon_search,
                iconFocused = R.drawable.icon_search_focused,
                text = "Search"
            ),
            BottomNavigationItem (
                icon = R.drawable.icon_bookmark,
                iconFocused = R.drawable.icon_bookmark_focused,
                text = "Bookmark"
            )
        )
    }

    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    var selectedItem by remember { mutableIntStateOf(0) }

    selectedItem = remember (key1 = navBackStackEntry) {
        when (navBackStackEntry?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.SearchScreen.route -> 1
            Route.BookmarkScreen.route -> 2
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = navBackStackEntry) {
        navBackStackEntry?.destination?.route == Route.HomeScreen.route ||
        navBackStackEntry?.destination?.route == Route.SearchScreen.route ||
        navBackStackEntry?.destination?.route == Route.BookmarkScreen.route
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                NewsifyBottomNavigation (
                    items = bottomNavigationItemData,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap (
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTap (
                                navController = navController,
                                route = Route.SearchScreen.route
                            )

                            2 -> navigateToTap (
                                navController = navController,
                                route = Route.BookmarkScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        NavHost (
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen (
                    navigateToSearch = {
                        navigateToTap (
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    },
                    navigateToDetails = { article ->
                        navigateToDetails (
                            navController = navController,
                            article = article
                        )
                    }
                )
            }
            composable(route = Route.SearchScreen.route) {
                SearchScreen (
                    navigateToDetails = { article ->
                        navigateToDetails (
                            navController = navController,
                            article = article
                        )
                    }
                )
            }
            composable(route = Route.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen (
                            article = article,
                            navigateUp = { navController.navigateUp() }
                        )
                    }
            }
            composable(route = Route.BookmarkScreen.route) {
                BookmarkScreen (
                    navigateToDetails = { article ->
                        navigateToDetails (
                            navController = navController,
                            article = article
                        )
                    }
                )
            }
        }
    }
}

fun navigateToTap (
    navController: NavController,
    route: String
) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) { saveState = true }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails (
    navController: NavController,
    article: Article
) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(route = Route.DetailsScreen.route)
}