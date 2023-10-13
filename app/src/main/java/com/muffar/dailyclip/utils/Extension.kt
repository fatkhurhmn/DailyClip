package com.muffar.dailyclip.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun Int.convertMinutesToHoursAndMinutes(): String {
    val hours = this / 60
    val remainingMinutes = this % 60

    return "$hours h $remainingMinutes m"
}

fun String.formatIsoDateToCustomFormat(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val outputFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
    return try {
        val date = inputFormat.parse(this) ?: ""
        outputFormat.format(date)
    } catch (e: Exception) {
        ""
    }
}