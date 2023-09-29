package com.example.contestreminders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ContestReminderData>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
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
        holder.contestSiteTimeLeftTextView.text = contestReminderData.getContestStartTime().toString()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val contestNameTextView: TextView = itemView.findViewById(R.id.contest_reminder_name)
        val contestSiteNameTextView: TextView = itemView.findViewById(R.id.contest_reminder_site)
        val contestSiteTimeLeftTextView: TextView = itemView.findViewById(R.id.contest_reminder_timeleft)
    }
}