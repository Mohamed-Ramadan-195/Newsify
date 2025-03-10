package com.example.newsify.presentation.screen.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsify.R
import com.example.newsify.domain.model.Article

@Composable
fun DetailsScreen(
    article: Article,
    navigateUp: () -> Unit
) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    if (detailsViewModel.sideEffect != null) {
        Toast.makeText(LocalContext.current, detailsViewModel.sideEffect, Toast.LENGTH_SHORT).show()
        detailsViewModel.onEvent(DetailsEvent.RemoveSideEffect)
    }

    DetailsScreenContent(
        article = article,
        detailsEvent = detailsViewModel::onEvent,
        navigateUp = navigateUp
    )
}

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun DetailsScreenContent(
    article: Article,
    detailsEvent: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {

    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .safeContentPadding()
    ) {
        DetailsTopBar (
            onBrowsingClick = {
                Intent (Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent (Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = { detailsEvent(DetailsEvent.InsertDeleteArticle(article)) },
            onBackClick = navigateUp
        )
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(24.dp)
        ) {
            item {
                AsyncImage (
                    model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(248.dp)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )
                Spacer (modifier = Modifier.height(24.dp))
                Text (
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.primary_text)
                )
                Text (
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.secondary_text)
                )
            }
        }
    }
}