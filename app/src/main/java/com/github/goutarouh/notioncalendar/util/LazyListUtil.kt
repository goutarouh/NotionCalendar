package com.github.goutarouh.notioncalendar.util

import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState

suspend fun LazyListState.animateScrollToCenterItem(index: Int, itemWidth: Int) {
    val listCenterPosition = layoutInfo.viewportSize.width / 2
    animateScrollToItem(index, -listCenterPosition + itemWidth / 2)
}