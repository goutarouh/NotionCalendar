package com.github.goutarouh.notioncalendar.ui

import android.util.Log
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
import com.github.goutarouh.notioncalendar.util.generateAroundDateList
import com.github.goutarouh.notioncalendar.util.scrollToCenterItem
import com.github.goutarouh.notioncalendar.util.toPx
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarViewPager(
    modifier: Modifier = Modifier,
    initialDate: LocalDate = LocalDate.now(),
) {
    val scope = rememberCoroutineScope()
    val dates = remember {
        val items = initialDate.generateAroundDateList()
        mutableStateOf(items)
    }
    val pageState = rememberPagerState(
        initialPage = dates.value.indexOf(initialDate)
    )
    val lazyListState = rememberLazyListState()
    Column(
        modifier = modifier
    ) {
        DateTabLayout(
            currentIndex = pageState.currentPage,
            dates = dates.value,
            lazyListState = lazyListState,
            onClicked = {
                scope.launch {
                    pageState.scrollToPage(it)
                }
            }
        )
        HorizontalPager(
            pageCount = dates.value.size,
            state = pageState,
        ) { page ->
            NotionPage(
                page = page,
                date = dates.value[page]
            )
        }
    }

    val tabWidthPx = TAB_WIDTH.toPx()
    LaunchedEffect(pageState.currentPage) {
        lazyListState.animateScrollToCenterItem(pageState.currentPage, tabWidthPx.toInt())
    }

    LaunchedEffect(Unit) {
        lazyListState.scrollToCenterItem(dates.value.indexOf(initialDate), tabWidthPx.toInt())
    }

    LaunchedEffect(pageState.settledPage) {
        val settlePage = pageState.settledPage
        if (settlePage == 3) {
            val current = dates.value[pageState.settledPage]
            val items = current.generateAroundDateList()
            dates.value = items
            lazyListState.scrollToCenterItem(dates.value.indexOf(current), tabWidthPx.toInt())
            pageState.scrollToPage(items.indexOf(current))
        }
        if (settlePage == dates.value.lastIndex - 3) {
            val current = dates.value[pageState.settledPage]
            val items = current.generateAroundDateList()
            dates.value = items
            lazyListState.scrollToCenterItem(dates.value.indexOf(current), tabWidthPx.toInt())
            pageState.scrollToPage(items.indexOf(current))
        }
    }
}