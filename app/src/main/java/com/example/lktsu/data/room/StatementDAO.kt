package com.example.lktsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lktsu.data.model.StatementEntity

@Dao
interface StatementDAO {
    @Query("SELECT * FROM ${StatementEntity.TABLE_NAME}")
    fun readStatementList(): List<StatementEntity>

    @Query("SELECT * FROM ${StatementEntity.TABLE_NAME} WHERE id=:id")
    fun readStatement(id: Long) : StatementEntity

    @Insert(entity = StatementEntity::class,  onConflict = OnConflictStrategy.REPLACE)
    fun addStatement(statementEntity: StatementEntity)
}