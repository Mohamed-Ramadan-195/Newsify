package com.example.newsify.presentation.onboarding.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsify.presentation.composables.NewsifyButton
import com.example.newsify.presentation.onboarding.components.OnBoardingPage
import com.example.newsify.presentation.onboarding.components.PageIndicator
import com.example.newsify.presentation.onboarding.model.pages
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen (
    onBoardingEvent: (OnBoardingEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("Next")
                    1 -> listOf("Next")
                    2 -> listOf("Get Started")
                    else -> listOf("")
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        PageIndicator (
            modifier = Modifier.width(48.dp),
            pageCount = pages.size,
            selectedPage = pagerState.currentPage
        )
        Spacer(modifier = Modifier.weight(1f))
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val scope = rememberCoroutineScope()
            if (buttonState.value[0].isNotEmpty()) {
                NewsifyButton (
                    text = buttonState.value[0],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                onBoardingEvent(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}