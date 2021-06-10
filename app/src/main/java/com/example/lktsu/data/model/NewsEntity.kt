package com.example.lktsu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NewsEntity.TABLE_NAME)
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val description: String,
) {
    companion object {
        const val TABLE_NAME = "news_table"
    }
}