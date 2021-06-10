package com.example.lktsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lktsu.data.model.NewsEntity
import com.example.lktsu.data.model.StudentEntity

@Dao
interface NewsDAO {
    @Query("SELECT * FROM ${NewsEntity.TABLE_NAME}")
    fun readNewsList(): List<NewsEntity>

    @Query("SELECT * FROM ${NewsEntity.TABLE_NAME} WHERE id=:id")
    fun readNews(id: Long) : NewsEntity

    @Insert(entity = NewsEntity::class,  onConflict = OnConflictStrategy.REPLACE)
    fun addNews(newsEntity: NewsEntity)
}