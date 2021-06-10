package com.example.lktsu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StatementEntity.TABLE_NAME)
data class StatementEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val description: String,
) {
    companion object {
        const val TABLE_NAME = "statement_table"
    }
}
