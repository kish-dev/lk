package com.example.lktsu.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = StudentEntity.TABLE_NAME)
data class StudentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0,
    val name: String,
    val group: String,
    val phone1: String = "",
    val phone2: String = "",
    val phone3: String = "",
    val email: String = "",
) {
    companion object {
        const val TABLE_NAME = "student_fio_table"
    }
}