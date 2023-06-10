package com.github.goutarouh.notioncalendar.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.notioncalendar.ui.AppHeader
import com.github.goutarouh.notioncalendar.ui.CalendarViewPager
import com.github.goutarouh.notioncalendar.util.toEpochSecond
import com.github.goutarouh.notioncalendar.util.toLocalDate
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = viewModel()
) {
    var currentSelectedDate by remember {
        mutableStateOf<LocalDate>(LocalDate.now())
    }
    var onDatePicker by remember {
        mutableStateOf(false)
    }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = currentSelectedDate.toEpochSecond()
    )
    Scaffold(
        topBar = {
            AppHeader(
                title = "NotionCalendar",
                currentDate = currentSelectedDate,
                setDate = { onDatePicker = true }
            )
        },
        content = { paddingValues ->
            CalendarViewPager(
                modifier = Modifier.padding(paddingValues),
                initialDate = currentSelectedDate,
                setDate = {
                    currentSelectedDate = it
                }
            )
            if (onDatePicker) {
                Dialog(onDismissRequest = {
                    onDatePicker = false
                }) {
                    Box(modifier = Modifier.background(Color.White)) {
                        DatePicker(datePickerState = datePickerState)
                    }
                }
            }
        }
    )
    LaunchedEffect(datePickerState.selectedDateMillis) {
        val selectedDateMills = datePickerState.selectedDateMillis ?: return@LaunchedEffect
        currentSelectedDate = selectedDateMills.toLocalDate()
        onDatePicker = false
    }
}