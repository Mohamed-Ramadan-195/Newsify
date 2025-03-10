package com.example.newsify.presentation.navigation.bottom_navigation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R
import com.example.newsify.ui.theme.NewsifyTheme
import com.example.newsify.ui.theme.PrimaryColor
import com.example.newsify.ui.theme.SecondaryColor

@Composable
fun NewsifyBottomNavigation (
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .border(1.dp, SecondaryColor),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem (
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Icon(
                        painter = painterResource(
                            if (index == selected) item.iconFocused
                            else item.icon
                        ),
                        contentDescription = "icon",
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.text,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = NavigationBarItemDefaults.colors (
                    selectedIconColor = PrimaryColor,
                    selectedTextColor = PrimaryColor,
                    unselectedIconColor = SecondaryColor,
                    unselectedTextColor = SecondaryColor,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NewsifyBottomNavigationPreview() {
    NewsifyTheme {
        NewsifyBottomNavigation (
            items = listOf (
                BottomNavigationItem (
                    icon = R.drawable.icon_home,
                    iconFocused = R.drawable.icon_home,
                    text = stringResource(R.string.home)
                ),
                BottomNavigationItem (
                    icon = R.drawable.icon_search,
                    iconFocused = R.drawable.icon_search_focused,
                    text = stringResource(R.string.search)
                ),
                BottomNavigationItem (
                    icon = R.drawable.icon_bookmark_focused,
                    iconFocused = R.drawable.icon_bookmark_focused,
                    text = stringResource(R.string.bookmark)
                )
            ),
            selected = 0,
            onItemClick = {}
        )
    }
}