package com.github.goutarouh.notioncalendar.repository

import com.github.goutarouh.notioncalendar.repository.data.NotionApiService
import com.github.goutarouh.notioncalendar.repository.model.NotionDatabase
import com.github.goutarouh.notioncalendar.repository.model.NotionDatabaseQuery
import com.github.goutarouh.notioncalendar.repository.model.NotionDatabaseQueryPostBody
import org.threeten.bp.LocalDate

class NotionRepository(
    private val notionApiService: NotionApiService
) {
    suspend fun retrieveDatabase(databaseId: String = "89ce313dbc8f4ec684e9f36eead785bb"): NotionDatabase {
        return notionApiService.retrieveDatabase(databaseId)
    }

    suspend fun queryDatabase(
        databaseId: String = "89ce313dbc8f4ec684e9f36eead785bb",
        currentDate: LocalDate = LocalDate.now()
    ): NotionDatabaseQuery {
        val body = NotionDatabaseQueryPostBody(
            filter = NotionDatabaseQueryPostBody.Filter(
                and = listOf(
                    NotionDatabaseQueryPostBody.Filter.And(NotionDatabaseQueryPostBody.Filter.And.Date(after = "2023-06-05")),
                    NotionDatabaseQueryPostBody.Filter.And(NotionDatabaseQueryPostBody.Filter.And.Date(before = "2023-06-15"))
                )
            )
        )
        return notionApiService.queryDatabase(databaseId, body)
    }
}