package com.github.goutarouh.notioncalendar.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.github.goutarouh.notioncalendar.util.LocalDateUtil
import org.threeten.bp.LocalDate

@Composable
fun NotionPage(
    page: Int,
    date: LocalDate
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = date.format(LocalDateUtil.localDateFormat), modifier = Modifier.align(Alignment.Center))
    }
}