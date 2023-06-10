package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.unit.sp
import com.github.goutarouh.notioncalendar.util.LocalDateUtil
import java.time.LocalDate

@Composable
fun DateTabLayout(
    currentIndex: Int,
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
                selected = index == currentIndex,
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
    selected: Boolean,
    onClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .widthIn(80.dp)
            .heightIn(40.dp)
            .clickable { onClicked(index) },
        contentAlignment = Alignment.Center
    ) {
        val fontSize = if (selected) {
            18.sp
        } else {
            14.sp
        }
        Text(
            text = date.format(LocalDateUtil.localDateFormat),
            fontSize = fontSize,
        )
    }
}