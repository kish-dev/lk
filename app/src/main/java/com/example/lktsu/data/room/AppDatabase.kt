package com.example.lktsu.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lktsu.data.model.*

@Database(
    entities = [StudentEntity::class,
        NewsEntity::class,
        StatementEntity::class,
        MarksEntity::class,
        HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDAO(): StudentDAO
    abstract fun newsDAO(): NewsDAO
    abstract fun statementDAO(): StatementDAO
    abstract fun marksDAO(): MarksDAO
    abstract fun historyDAO(): HistoryDAO
}
