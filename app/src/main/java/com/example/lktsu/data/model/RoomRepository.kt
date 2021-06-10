package com.example.lktsu.data.model

import androidx.room.Query
import com.example.lktsu.data.model.StudentEntity

interface RoomRepository {
    suspend fun getStudent(id: String) : StudentEntity
    suspend fun getStudents() : List<StudentEntity>
    suspend fun insertStudent(studentEntity: StudentEntity)
    suspend fun updatePhone1(id: Long, phone1: String) : Int
    suspend fun updatePhone2(id:Long, phone2: String): Int
    suspend fun updatePhone3(id:Long, phone3: String): Int
    suspend fun updateEmail(id:Long, email: String): Int
}