package com.example.lktsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lktsu.data.model.MarksEntity
import javax.security.auth.Subject

@Dao
interface MarksDAO {
    @Query("SELECT * FROM ${MarksEntity.TABLE_NAME} WHERE student_id=:studentId")
    fun readStudentMarks(studentId: Long) : List<MarksEntity>

    @Query("SELECT * FROM ${MarksEntity.TABLE_NAME} WHERE student_id=:studentId AND semester=:semester")
    fun readStudentMarksForSemester(studentId: Long, semester: Long) : List<MarksEntity>

    @Insert(entity = MarksEntity::class,  onConflict = OnConflictStrategy.REPLACE)
    fun addMark(marksEntity: MarksEntity)

    @Query("SELECT * FROM ${MarksEntity.TABLE_NAME} WHERE student_id=:studentId AND subject=:subject AND semester=:semester")
    fun readStudentMarkForSubject(studentId: Long, subject: String, semester: Int) : MarksEntity

}
