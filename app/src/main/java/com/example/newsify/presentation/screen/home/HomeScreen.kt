package com.example.newsify.presentation.screen.home

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.newsify.R
import com.example.newsify.domain.model.Article
import com.example.newsify.presentation.composables.NewsifyList
import com.example.newsify.presentation.composables.NewsifySearchBar
import com.example.newsify.util.Constant.EMPTY_STRING

@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            } else {
                EMPTY_STRING
            }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
            .statusBarsPadding(),
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary_text)
        )
        Spacer(modifier = Modifier.padding(24.dp))
        NewsifySearchBar (
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            text = EMPTY_STRING,
            readOnly = true,
            onValueChange = {},
            onClick = {
                navigateToSearch()
            },
            onSearch = {}
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text (
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.secondary_text)
        )
        Spacer (modifier = Modifier.height(24.dp))
        NewsifyList(
            modifier = Modifier.padding(horizontal = 24.dp),
            articles = articles,
            onClick = { navigateToDetails(it) }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

}