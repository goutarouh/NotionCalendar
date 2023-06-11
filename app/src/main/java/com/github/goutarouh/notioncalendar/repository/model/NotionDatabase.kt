package com.github.goutarouh.notioncalendar.repository.model
import com.squareup.moshi.Json

data class NotionDatabase(
    @Json(name = "archived")
    val archived: Boolean?,
    @Json(name = "cover")
    val cover: Cover?,
    @Json(name = "created_by")
    val createdBy: CreatedBy?,
    @Json(name = "created_time")
    val createdTime: String?,
    @Json(name = "description")
    val description: List<Any?>?,
    @Json(name = "icon")
    val icon: Any?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "is_inline")
    val isInline: Boolean?,
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
    @Json(name = "title")
    val title: List<Title?>?,
    @Json(name = "url")
    val url: String?
) {
    data class Cover(
        @Json(name = "external")
        val `external`: External?,
        @Json(name = "type")
        val type: String?
    ) {
        data class External(
            @Json(name = "url")
            val url: String?
        )
    }

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
        @Json(name = "page_id")
        val pageId: String?,
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
            val multiSelect: MultiSelect?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "type")
            val type: String?
        ) {
            data class MultiSelect(
                @Json(name = "options")
                val options: List<Any?>?
            )
        }

        data class NotionName(
            @Json(name = "id")
            val id: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "title")
            val title: Title?,
            @Json(name = "type")
            val type: String?
        ) {
            class Title
        }

        data class NotionDate(
            @Json(name = "date")
            val date: Date?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "type")
            val type: String?
        ) {
            class Date
        }
    }

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