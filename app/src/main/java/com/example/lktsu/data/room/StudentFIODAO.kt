package com.example.lktsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lktsu.data.model.StudentEntity

@Dao
interface StudentDAO {
    @Insert(entity = StudentEntity::class,  onConflict = OnConflictStrategy.REPLACE)
    fun addStudent(student: StudentEntity)

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE id=:id")
    fun readStudent(id: Long): StudentEntity

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME}")
    fun readStudents(): List<StudentEntity>

    @Query("UPDATE ${StudentEntity.TABLE_NAME} SET phone1 = :phone1 WHERE id = :id")
    fun updatePhone1(id: Long, phone1: String): Int

    @Query("UPDATE ${StudentEntity.TABLE_NAME} SET phone2 = :phone2 WHERE id = :id")
    fun updatePhone2(id: Long, phone2: String): Int

    @Query("UPDATE ${StudentEntity.TABLE_NAME} SET phone3 = :phone3 WHERE id = :id")
    fun updatePhone3(id: Long, phone3: String): Int

    @Query("UPDATE ${StudentEntity.TABLE_NAME} SET email = :email WHERE id = :id")
    fun updateEmail(id: Long, email: String): Int
}