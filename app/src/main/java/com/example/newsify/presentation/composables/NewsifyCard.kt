package com.example.newsify.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsify.R
import com.example.newsify.domain.model.Article
import com.example.newsify.domain.model.Source

@Composable
fun NewsifyCard (
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = Modifier.clickable { onClick() }) {
        AsyncImage (
            modifier = modifier
                .size(96.dp)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier
                .padding(horizontal = 3.dp)
                .height(96.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text (
                text = article.title,
                fontSize = 14.sp,
                color = colorResource(R.color.primary_text),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text (
                    text = article.source.name,
                    fontSize = 12.sp,
                    color = colorResource(R.color.secondary_text)
                )
                Spacer (modifier = Modifier.width(6.dp))
                Icon (
                    painter = painterResource(R.drawable.icon_time),
                    contentDescription = null,
                    modifier = Modifier.size(10.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text (
                    text = article.publishedAt,
                    fontSize = 12.sp,
                    color = colorResource(R.color.secondary_text)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NewsifyCardPreview() {
    NewsifyCard (
        article = Article (
            author = "",
            content = "",
            description = "",
            publishedAt = "",
            source = Source(id = "", name = ""),
            title = "",
            url = "",
            urlToImage = ""
        )
    ) {  }
}