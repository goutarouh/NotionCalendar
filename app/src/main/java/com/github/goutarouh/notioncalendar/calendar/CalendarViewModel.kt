package com.github.goutarouh.notioncalendar.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.goutarouh.notioncalendar.repository.NotionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val notionRepository: NotionRepository
) : ViewModel() {

    fun getDatabase() {
        viewModelScope.launch {
            val database = try {
                notionRepository.getDatabase()
            } catch (e: Exception) {
                return@launch
            }
        }
    }
}