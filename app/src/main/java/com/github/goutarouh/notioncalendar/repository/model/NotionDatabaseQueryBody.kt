package com.github.goutarouh.notioncalendar.repository.model
import com.squareup.moshi.Json

data class NotionDatabaseQueryPostBody(
    @Json(name = "filter")
    val filter: Filter
) {
    data class Filter(
        @Json(name = "and")
        val and: List<And>
    ) {
        data class And(
            @Json(name = "date")
            val date: Date,
            @Json(name = "property")
            val `property`: String = "日付"
        ) {
            data class Date(
                @Json(name = "after")
                val after: String? = null,
                @Json(name = "before")
                val before: String? = null
            )
        }
    }
}