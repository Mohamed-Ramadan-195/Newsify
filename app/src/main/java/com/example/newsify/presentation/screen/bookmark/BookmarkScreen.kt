package com.example.newsify.presentation.screen.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsify.R
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.Dimen.LargeSpace
import com.example.newsify.presentation.composables.NewsifyList

@Composable
fun BookmarkScreen(
    navigateToDetails: (Article) -> Unit
) {
    val bookmarkViewModel: BookmarkViewModel = hiltViewModel()
    val bookmarkState = bookmarkViewModel.state.value

    BookmarkScreenContent(
        bookmarkState = bookmarkState,
        navigateToDetails = navigateToDetails
    )
}

@Composable
fun BookmarkScreenContent (
    bookmarkState: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .navigationBarsPadding()
            .safeContentPadding()
            .padding (16.dp)
    ) {
        Text (
            text = "Bookmark",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.primary_text)
        )
            Spacer(modifier = Modifier.height(LargeSpace))
        NewsifyList (
            articles = bookmarkState.articles,
            onClick = { navigateToDetails(it) }
        )
    }
}