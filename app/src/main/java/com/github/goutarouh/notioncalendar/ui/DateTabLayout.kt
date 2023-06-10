package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
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
    dates: List<LocalDate>,
    lazyListState: LazyListState,
    onClicked: (Int) -> Unit,
) {
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
        item {
            NewDataTab {

            }
        }
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
            .widthIn(TAB_WIDTH)
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

@Composable
fun NewDataTab(load: () -> Unit) {
    LaunchedEffect(Unit) {
        load()
    }
}

val TAB_WIDTH = 80.dp