package com.github.goutarouh.notioncalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.goutarouh.notioncalendar.ui.AppHeader
import com.github.goutarouh.notioncalendar.ui.CalendarViewPager
import com.github.goutarouh.notioncalendar.ui.theme.NotionCalendarTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotionCalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    var currentSelectedDate by remember {
                        mutableStateOf<LocalDate>(LocalDate.now())
                    }
                    Scaffold(
                        topBar = {
                            AppHeader(
                                title = "NotionCalendar",
                                currentDate = currentSelectedDate,
                                setDate = { currentSelectedDate = it }
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
                        }
                    )
                }
            }
        }
    }
}