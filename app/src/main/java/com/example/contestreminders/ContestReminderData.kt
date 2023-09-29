package com.example.contestreminders

class ContestReminderData(var contestSiteName: String, var contestName: String, var contestStartTime: Long)
{
    fun getContestSiteName() = contestSiteName
    fun getContestName() = contestName
    fun getContestStartTime() = contestStartTime

    fun getTimeRemainingTillStart(): Long {
        return contestStartTime - System.currentTimeMillis()
    }

    // To be removed when actual data is populated via fetching data from sites
    fun setDummyData() {
        contestSiteName = "contest site name " + (0..100).random()
        contestName = "contest name " + (0..100).random()
        contestStartTime = (System.currentTimeMillis() * 1.1).toLong()
    }
}