package com.example.contestreminders

import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class ContestTimeUtils {

    companion object {

        private val SECONDS_IN_DAY = 86400
        private val SECONDS_IN_HOUR = 3600
        private val SECONDS_IN_MINUTE = 60

        fun getTimeRemainingTillStart(startTime: Long): Long = startTime - System.currentTimeMillis()

        fun convertLongToDDHHMMSS(timeInMilliSeconds: Long): String {
            var timeInSeconds = timeInMilliSeconds / 1000

            val days = timeInSeconds / SECONDS_IN_DAY
            timeInSeconds %= SECONDS_IN_DAY
            val hours = timeInSeconds / SECONDS_IN_HOUR
            timeInSeconds %= SECONDS_IN_HOUR
            val minutes = timeInSeconds / SECONDS_IN_MINUTE
            timeInSeconds %= SECONDS_IN_MINUTE
            val seconds = timeInSeconds

            return "${days}d ${hours}h ${minutes}m ${seconds}s"
        }

        fun convertUnixToDateTime(unixTimeMillis: Long): String {
            val instant = Instant.ofEpochMilli(unixTimeMillis)
            val localDateTime = LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault())

            // Use a custom pattern without seconds
            val customFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy hh:mm a", Locale.ENGLISH)

            return localDateTime.format(customFormatter)
        }
    }
}