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

suspend fun LazyListState.scrollToCenterItem(index: Int, itemWidth: Int) {
    val listCenterPosition = layoutInfo.viewportSize.width / 2
    scrollToItem(index, -listCenterPosition + itemWidth / 2)
}
