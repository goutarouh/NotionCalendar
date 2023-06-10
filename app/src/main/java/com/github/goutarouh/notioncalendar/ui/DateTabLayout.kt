package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.goutarouh.notioncalendar.util.LocalDateUtil
import java.time.LocalDate

@Composable
fun DateTabLayout(
    initialDate: LocalDate,
    lazyListState: LazyListState,
    onClicked: (Int) -> Unit,
) {
    val dates = List(21) { initialDate.minusDays(10).plusDays(it.toLong()) }
    LazyRow(
        state = lazyListState
    ) {
        itemsIndexed(dates) { index, date ->
            DateTab(
                index = index,
                date = date,
                onClicked = { onClicked(it) }
            )
        }
    }

    LaunchedEffect(Unit) {
        lazyListState.scrollToItem(10)
    }
}

@Composable
fun DateTab(
    index: Int,
    date: LocalDate,
    onClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(80.dp)
            .height(40.dp)
            .clickable { onClicked(index) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = date.format(LocalDateUtil.localDateFormat))
    }
}