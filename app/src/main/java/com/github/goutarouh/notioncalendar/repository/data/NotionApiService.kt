package com.github.goutarouh.notioncalendar.repository.data

import com.github.goutarouh.notioncalendar.BuildConfig
import com.github.goutarouh.notioncalendar.repository.model.NotionDatabase
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NotionApiService {
    @Headers(
        *arrayOf(
            "Authorization: Bearer ${BuildConfig.NOTION_API_KEY}",
            "Notion-Version: 2022-06-28",
            "Content-Type: application/json"
        )
    )
    @GET("databases/{database_id}")
    suspend fun getDatabase(
        @Path("database_id") databaseId: String
    ): NotionDatabase
}