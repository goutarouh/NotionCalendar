package com.github.goutarouh.notioncalendar.repository.model
import com.squareup.moshi.Json


data class NotionDatabaseQuery(
    @Json(name = "has_more")
    val hasMore: Boolean?,
    @Json(name = "next_cursor")
    val nextCursor: Any?,
    @Json(name = "object")
    val objectX: String?,
    @Json(name = "page")
    val page: Page?,
    @Json(name = "results")
    val results: List<Result?>?,
    @Json(name = "type")
    val type: String?
) {
    class Page

    data class Result(
        @Json(name = "archived")
        val archived: Boolean?,
        @Json(name = "cover")
        val cover: Any?,
        @Json(name = "created_by")
        val createdBy: CreatedBy?,
        @Json(name = "created_time")
        val createdTime: String?,
        @Json(name = "icon")
        val icon: Any?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "last_edited_by")
        val lastEditedBy: LastEditedBy?,
        @Json(name = "last_edited_time")
        val lastEditedTime: String?,
        @Json(name = "object")
        val objectX: String?,
        @Json(name = "parent")
        val parent: Parent?,
        @Json(name = "properties")
        val properties: Properties?,
        @Json(name = "public_url")
        val publicUrl: Any?,
        @Json(name = "url")
        val url: String?,
        @Json(name = " ")
        val x: String?
    ) {
        data class CreatedBy(
            @Json(name = "id")
            val id: String?,
            @Json(name = "object")
            val objectX: String?
        )

        data class LastEditedBy(
            @Json(name = "id")
            val id: String?,
            @Json(name = "object")
            val objectX: String?
        )

        data class Parent(
            @Json(name = "database_id")
            val databaseId: String?,
            @Json(name = "type")
            val type: String?
        )

        data class Properties(
            @Json(name = "タグ")
            val tag: NotionTag?,
            @Json(name = "名前")
            val name: NotionName?,
            @Json(name = "日付")
            val date: NotionDate?
        ) {
            data class NotionTag(
                @Json(name = "id")
                val id: String?,
                @Json(name = "multi_select")
                val multiSelect: List<Any?>?,
                @Json(name = "type")
                val type: String?
            )

            data class NotionName(
                @Json(name = "id")
                val id: String?,
                @Json(name = "title")
                val title: List<Title?>?,
                @Json(name = "type")
                val type: String?
            ) {
                data class Title(
                    @Json(name = "annotations")
                    val annotations: Annotations?,
                    @Json(name = "href")
                    val href: Any?,
                    @Json(name = "plain_text")
                    val plainText: String?,
                    @Json(name = "text")
                    val text: Text?,
                    @Json(name = "type")
                    val type: String?
                ) {
                    data class Annotations(
                        @Json(name = "bold")
                        val bold: Boolean?,
                        @Json(name = "code")
                        val code: Boolean?,
                        @Json(name = "color")
                        val color: String?,
                        @Json(name = "italic")
                        val italic: Boolean?,
                        @Json(name = "strikethrough")
                        val strikethrough: Boolean?,
                        @Json(name = "underline")
                        val underline: Boolean?
                    )

                    data class Text(
                        @Json(name = "content")
                        val content: String?,
                        @Json(name = "link")
                        val link: Any?
                    )
                }
            }

            data class NotionDate(
                @Json(name = "date")
                val date: Date?,
                @Json(name = "id")
                val id: String?,
                @Json(name = "type")
                val type: String?
            ) {
                data class Date(
                    @Json(name = "end")
                    val end: Any?,
                    @Json(name = "start")
                    val start: String?,
                    @Json(name = "time_zone")
                    val timeZone: Any?
                )
            }
        }
    }
}