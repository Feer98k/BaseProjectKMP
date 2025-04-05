package com.f98k.tipstermindcocoapods.ui.screen.home.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiActions
import com.f98k.tipstermindcocoapods.ui.screen.home.state.HomeUiState
import com.f98k.tipstermindcocoapods.ui.theme.TipsterTextTypeEnum
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.f98k.tipstermindcocoapods.ui.components.TipsterText
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings
import com.f98k.tipstermindcocoapods.data.model.home.TabItem
import com.f98k.tipstermindcocoapods.domain.bridge.getImageResource
import com.f98k.tipstermindcocoapods.domain.helper.setColorByTheme
import com.f98k.tipstermindcocoapods.ui.components.TipsterColors.BackgroundDark
import com.f98k.tipstermindcocoapods.ui.components.TipsterColors.DividerGray
import com.f98k.tipstermindcocoapods.ui.components.TipsterIcon
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    uiStateAction: HomeUiActions
) {

    val tabs = listOf(
        TabItem("ic_pray", LocalizedStrings.dailyPrayer()) { DailyPrayerContent(uiState,uiStateAction) },
        TabItem("ic_bible", LocalizedStrings.dailyVerse()) { DailyVerseContent(uiState,uiStateAction) },
        TabItem("ic_sermon", LocalizedStrings.dailySermon()) { DailySermonContent(uiState,uiStateAction) }
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 1, pageCount = {tabs.size})

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = MaterialTheme.colors.onBackground.copy(alpha = 0.04f),
            contentColor = MaterialTheme.colors.primary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = MaterialTheme.colors.primary
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            TipsterIcon(
                                tab.iconName,
                                contentDescription = tab.title,
                                modifier = Modifier
                                    .size(18.dp)
                                    .padding(end = 4.dp)
                            )
                            TipsterText(
                                text = tab.title,
                                type = TipsterTextTypeEnum.Body,
                                singleLine = true,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            tabs[page].content()
        }
    }
}