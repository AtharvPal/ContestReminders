package com.example.contestreminders

import android.graphics.Color
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ContestReminderData>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var TIMER_INTERVAL_MS = 1000L

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contest_reminder_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contestReminderData = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.contestNameTextView.text = contestReminderData.getContestName()
        holder.contestSiteNameTextView.text = contestReminderData.getContestSiteName()
        val timeOfStarting = contestReminderData.getContestStartTime()
        holder.contextStartDateTime.text = ContestTimeUtils.convertUnixToDateTime(timeOfStarting)
        val timeTillStart = ContestTimeUtils.getTimeRemainingTillStart(timeOfStarting)
        // For timer, time till end has to be passed in ms
        holder.contestTimeLeftTimer = MyTimer(holder.contestTimeLeftTextView, timeTillStart, TIMER_INTERVAL_MS)
        holder.contestTimeLeftTimer.start()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val contestNameTextView: TextView = itemView.findViewById(R.id.contest_reminder_name)
        val contestSiteNameTextView: TextView = itemView.findViewById(R.id.contest_reminder_site)
        val contestTimeLeftTextView: TextView = itemView.findViewById(R.id.contest_reminder_timeleft)
        val contextStartDateTime: TextView = itemView.findViewById(R.id.contest_reminder_date_time)
        lateinit var contestTimeLeftTimer: MyTimer
    }

    class MyTimer(private var textView: TextView, timeInMillis: Long, interval: Long) : CountDownTimer(timeInMillis, interval) {
        override fun onTick(p0: Long) {
            textView.setText(ContestTimeUtils.convertLongToDDHHMMSS(p0))
            textView.setTextColor(Color.GREEN)
        }

        override fun onFinish() {
            // TODO - have a better handling when contest time is up
            textView.setText("Started")
            textView.setTextColor(Color.RED)
        }
    }
}