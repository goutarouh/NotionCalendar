package com.github.goutarouh.notioncalendar.repository.data

import com.github.goutarouh.notioncalendar.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NotionApiService {
    @Headers(
        *arrayOf(
            "Authorization: Bearer ${BuildConfig.NOTION_API_KEY}",
            "Notion-Version: 2022-06-28"
        )
    )
    @GET("v1/blocks/{block_id}/children?page_size=100")
    suspend fun retrieveBlockChildren(
        @Path("block_id") blockId: String
    ): Any
}