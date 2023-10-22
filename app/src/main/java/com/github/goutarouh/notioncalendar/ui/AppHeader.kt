package com.github.goutarouh.notioncalendar.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import org.threeten.bp.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    title: String,
    currentDate: LocalDate,
    setDate: (LocalDate) -> Unit
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            Text(
                text = currentDate.year.toString()
            )
            IconButton(
                onClick = {
                    setDate(LocalDate.of(2022, 4, 3))
                }
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = ""
                )
            }
        }
    )
}