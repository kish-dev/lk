package com.example.lktsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lktsu.data.model.HistoryEntity
import com.example.lktsu.data.model.MarksEntity

@Dao
interface HistoryDAO {
    @Insert(entity = HistoryEntity::class,  onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM ${HistoryEntity.TABLE_NAME} WHERE number=:number")
    fun readHistory(number: Long) : HistoryEntity
}
