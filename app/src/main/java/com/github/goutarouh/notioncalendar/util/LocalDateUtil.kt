package com.github.goutarouh.notioncalendar.util

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

object LocalDateUtil {
    val localDateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("M/d")
}

fun LocalDate.toEpochSecond(): Long {
    return this.toEpochDay() * 24 * 60 * 60 * 1000
}

fun Long.toLocalDate(): LocalDate {
    return LocalDate.ofEpochDay(this / 24 / 60 / 60 / 1000)
}

fun LocalDate.generateAroundDateList(): List<LocalDate> {
    val length = 100000
    return List(length) { this.minusDays(length / 2L).plusDays(it.toLong()) }
}