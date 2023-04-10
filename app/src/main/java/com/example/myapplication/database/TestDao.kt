package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TestDao {
    @Query("SELECT * FROM test")
    fun getAll(): List<Test>

    @Query("SELECT * FROM test WHERE uid IN (:testIds)")
    fun loadAllByIds(testIds: IntArray): List<Test>

    @Query("SELECT * FROM test WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Test

    @Insert
    fun insertAll(vararg tests: Test)

    @Delete
    fun delete(test: Test)
}
