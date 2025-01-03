package com.example.newsify.presentation.screen.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.composables.NewsifyList

@Composable
fun BookmarkScreen (
    bookmarkState: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding (
                top = 24.dp,
                start = 24.dp,
                end = 24.dp,
            )
    ) {
        Text (
            text = "Bookmark",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.primary_text)
        )
        Spacer(modifier = Modifier.height(24.dp))
        NewsifyList (
            articles = bookmarkState.articles,
            onClick = { navigateToDetails(it) }
        )
    }
}