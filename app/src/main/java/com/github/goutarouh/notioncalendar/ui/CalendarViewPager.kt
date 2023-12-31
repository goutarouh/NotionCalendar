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
import com.github.goutarouh.notioncalendar.util.generateAroundDateList
import com.github.goutarouh.notioncalendar.util.scrollToCenterItem
import com.github.goutarouh.notioncalendar.util.toPx
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarViewPager(
    modifier: Modifier = Modifier,
    initialDate: LocalDate,
    setDate: (LocalDate) -> Unit,
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
        val currentDate = dates.value[pageState.currentPage]
        setDate(currentDate)
    }

    LaunchedEffect(initialDate) {
        lazyListState.scrollToCenterItem(dates.value.indexOf(initialDate), tabWidthPx.toInt())
        pageState.scrollToPage(dates.value.indexOf(initialDate))
    }
}