package uas_C14220151.app.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateHelper {
    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat(
            "yyyy/MM/dd HH:mm:ss",
            Locale.getDefault()
        )
        val date = Date()
        return dateFormat.format(date)
    }

    fun getCurrentTime(): String {
        val timeFormat = SimpleDateFormat(
            "HH:mm:ss",
            Locale.getDefault()
        )
        val date = Date()
        return timeFormat.format(date)
    }
}