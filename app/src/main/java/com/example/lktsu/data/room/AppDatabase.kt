package com.example.lktsu.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lktsu.data.model.StudentEntity

@Database(
    entities = [StudentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDAO() : StudentDAO
}