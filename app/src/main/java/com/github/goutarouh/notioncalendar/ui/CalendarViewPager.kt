package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.github.goutarouh.notioncalendar.util.animateScrollToCenterItem
import com.github.goutarouh.notioncalendar.util.toPx
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarViewPager(
    modifier: Modifier = Modifier,
    initialDate: LocalDate = LocalDate.now(),
    dates: List<LocalDate> = List(21) { initialDate.minusDays(10).plusDays(it.toLong()) }
) {
    val scope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    val pageState = rememberPagerState(
        initialPage = 10
    )
    val mDates = remember {
        mutableStateOf(dates)
    }
    Column(
        modifier = modifier
    ) {
        DateTabLayout(
            currentIndex = pageState.currentPage,
            dates = mDates.value,
            lazyListState = lazyListState,
            onClicked = {
                scope.launch {
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

    val tabWidthPx = TAB_WIDTH.toPx()
    LaunchedEffect(pageState.currentPage) {
        lazyListState.animateScrollToCenterItem(pageState.currentPage, tabWidthPx.toInt())
    }

    LaunchedEffect(Unit) {
        lazyListState.animateScrollToCenterItem(dates.indexOf(initialDate), tabWidthPx.toInt())
    }
}