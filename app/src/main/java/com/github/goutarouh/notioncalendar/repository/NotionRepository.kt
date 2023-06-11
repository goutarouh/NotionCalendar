package com.github.goutarouh.notioncalendar.repository

import com.github.goutarouh.notioncalendar.repository.data.NotionApiService
import com.github.goutarouh.notioncalendar.repository.model.NotionDatabase

class NotionRepository(
    private val notionApiService: NotionApiService
) {
    suspend fun getDatabase(databaseId: String = "89ce313dbc8f4ec684e9f36eead785bb"): NotionDatabase {
        return notionApiService.getDatabase(databaseId)
    }
}