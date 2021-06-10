package com.example.lktsu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = HistoryEntity.TABLE_NAME)
data class HistoryEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val number: Long,
    val history: String,
) {
    companion object {
        const val TABLE_NAME = "history_table"
    }
}
