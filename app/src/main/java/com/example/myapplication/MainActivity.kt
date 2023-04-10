package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.room.Room
import com.example.myapplication.database.Test
import com.example.myapplication.database.testDB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            testDB::class.java, "test"
        ).allowMainThreadQueries().build()

        val testDao = db.testDao()
        testDao.insertAll(Test(10, "sam", "luther"))

        val users: List<Test> = testDao.getAll()

        val entries: TextView = findViewById(R.id.entries);

        entries.text = users.toString();
    }
}