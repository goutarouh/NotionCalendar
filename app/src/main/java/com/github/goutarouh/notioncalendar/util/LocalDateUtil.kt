package com.github.goutarouh.notioncalendar.util

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

object LocalDateUtil {
    val localDateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("M/d")
}

fun LocalDate.generateAroundDateList(): List<LocalDate> {
    val length = 100000
    return List(length) { this.minusDays(length/2L).plusDays(it.toLong()) }
}

fun datesInMonth(date: LocalDate): List<LocalDate> {
    val start = date.withDayOfMonth(1)
    val end = YearMonth.from(date).atEndOfMonth()
    return generateSequence(start) { it.plusDays(1) }
        .takeWhile { !it.isAfter(end) }
        .toList()
}