package com.example.newsify.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R
import com.example.newsify.presentation.onboarding.model.Page
import com.example.newsify.presentation.onboarding.model.pages

@Composable
fun OnBoardingPage (
    modifier: Modifier = Modifier,
    page: Page
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(page.image),
            contentDescription = "on boarding image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text (
            text = page.title,
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.primary_text)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text (
            text = page.body,
            modifier = Modifier.padding(horizontal = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.secondary_text)
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
@Preview(name = "Light", showBackground = true)
fun OnBoardingPagePreview() {
    OnBoardingPage(page = pages[0])
}