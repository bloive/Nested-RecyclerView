package com.example.nestedrecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class Item(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo val title: String?,
    @ColumnInfo val description: String?,
    @ColumnInfo val pictureUrl: String?
) {
    constructor(
        title: String?,
        description: String?,
        pictureUrl: String?,
    ) : this(0, title, description, pictureUrl)
}
