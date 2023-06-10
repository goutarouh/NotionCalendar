package com.github.goutarouh.notioncalendar.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Int.toDp(): Dp {
    val density = LocalDensity.current
    return with (density) { this@toDp.toDp() }
}

@Composable
fun Dp.toPx(): Float {
    val density = LocalDensity.current
    return with (density) { this@toPx.toPx() }
}