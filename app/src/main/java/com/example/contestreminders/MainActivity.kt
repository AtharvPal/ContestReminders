package com.example.contestreminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        var list_view = findViewById<RecyclerView>(R.id.contest_reminder_list)

        list_view.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ContestReminderData>()
        for (i in 1..20)
            data.add(ContestReminderData("Codeforces", "Div 2", 1711005683 * 1000L))

        val adapter = CustomAdapter(data)

        list_view.adapter = adapter
    }
}