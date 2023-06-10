package com.github.goutarouh.notioncalendar.util

import androidx.compose.foundation.lazy.LazyListState

suspend fun LazyListState.animateScrollToCenterItem(index: Int) {
    val listCenterPosition = layoutInfo.viewportSize.width / 2
    val targetItem = layoutInfo.visibleItemsInfo.firstOrNull { it.index == index } ?: return
    val targetItemHalfWidth = targetItem.size / 2
    animateScrollToItem(index, -listCenterPosition + targetItemHalfWidth)
}