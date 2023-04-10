package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Test::class], version = 1)
abstract class testDB : RoomDatabase() {
    abstract fun testDao(): TestDao
}