package com.example.contestreminders

class ContestReminderData(private var contestSiteName: String, private var contestName: String, private var contestStartTime: Long)
{
    fun getContestSiteName() = contestSiteName
    fun getContestName() = contestName
    fun getContestStartTime() = contestStartTime


}