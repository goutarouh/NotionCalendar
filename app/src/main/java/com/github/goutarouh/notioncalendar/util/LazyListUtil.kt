package com.github.goutarouh.notioncalendar.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

suspend fun LazyListState.animateScrollToCenterItem(index: Int, itemWidth: Int) {
    val listCenterPosition = layoutInfo.viewportSize.width / 2
    animateScrollToItem(index, -listCenterPosition + itemWidth / 2)
}

@Composable
fun LazyListState.OnAppearLastItem(onAppearLastItem: (Int) -> Unit) {
    val isReachedToEnd by remember {
        derivedStateOf {
            layoutInfo.visibleItemsInfo.size < layoutInfo.totalItemsCount &&
                    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
        }
    }
    LaunchedEffect(Unit) {
        snapshotFlow { isReachedToEnd }
            .filter { it }
            .collect {
                onAppearLastItem(layoutInfo.totalItemsCount-2)
            }
    }
}