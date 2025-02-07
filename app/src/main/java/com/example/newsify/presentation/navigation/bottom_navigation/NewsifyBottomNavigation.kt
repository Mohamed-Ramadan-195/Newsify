package com.example.newsify.presentation.navigation.bottom_navigation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R
import com.example.newsify.ui.theme.NewsifyTheme

@Composable
fun NewsifyBottomNavigation (
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar (
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem (
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon (
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text (
                            text = item.text,
                            fontSize = 10.sp
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors (
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface
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
                    text = stringResource(R.string.home)
                ),
                BottomNavigationItem (
                    icon = R.drawable.icon_search,
                    text = stringResource(R.string.search)
                ),
                BottomNavigationItem (
                    icon = R.drawable.icon_bookmark,
                    text = stringResource(R.string.bookmark)
                )
            ),
            selected = 0,
            onItemClick = {}
        )
    }
}