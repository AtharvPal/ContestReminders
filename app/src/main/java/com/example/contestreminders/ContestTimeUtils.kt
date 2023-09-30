package com.example.contestreminders

class ContestTimeUtils {

    companion object {

        private val SECONDS_IN_DAY = 86400
        private val SECONDS_IN_HOUR = 3600
        private val SECONDS_IN_MINUTE = 60

        fun getTimeRemainingTillStart(startTime: Long): Long = startTime - System.currentTimeMillis()

        fun convertLongToHHMMSS(timeInMilliSeconds: Long): String {
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
    }
}