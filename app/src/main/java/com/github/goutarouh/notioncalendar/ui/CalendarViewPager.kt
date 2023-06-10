package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarViewPager(
    initialDate: LocalDate = LocalDate.now()
) {
    val scope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    val dates = List(21) { initialDate.minusDays(10).plusDays(it.toLong()) }
    val pageState = rememberPagerState(
        initialPage = 10
    )
    Column {
        DateTabLayout(
            initialDate = initialDate,
            lazyListState = lazyListState,
            onClicked = {
                scope.launch {
                    lazyListState.animateScrollToItem(it)
                    pageState.scrollToPage(it)
                }
            }
        )
        HorizontalPager(
            pageCount = dates.size,
            state = pageState,
        ) { page ->
            NotionPage(
                page = page,
                date = dates[page]
            )
        }
    }

    LaunchedEffect(pageState.currentPage) {
        lazyListState.animateScrollToItem(pageState.currentPage)
    }
}