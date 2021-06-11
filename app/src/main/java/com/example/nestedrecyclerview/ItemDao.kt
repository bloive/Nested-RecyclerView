package com.example.nestedrecyclerview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<Item>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): Item

    @Insert
    suspend fun insertUser(vararg user: Item)

    @Delete
    suspend fun delete(user: Item)
}