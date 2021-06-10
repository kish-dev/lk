package com.example.lktsu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.security.auth.Subject

@Entity(tableName = MarksEntity.TABLE_NAME)
data class MarksEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val student_id: Long,
    val subject: String,
    val mark: String,
    val semester: Long,
    val event: String
) {
    companion object {
        const val TABLE_NAME = "marks_table"
    }
}
