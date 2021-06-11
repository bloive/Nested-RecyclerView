package com.example.nestedrecyclerview

import androidx.room.Room

object Database {
    val db: ItemDatabase = Room.databaseBuilder(
        App.context!!,
        ItemDatabase::class.java, "database-user"
    ).build()
}