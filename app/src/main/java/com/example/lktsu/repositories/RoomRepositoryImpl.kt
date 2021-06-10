package com.example.lktsu.repositories

import android.util.Log
import com.example.lktsu.data.model.RoomRepository
import com.example.lktsu.data.model.StudentEntity
import com.example.lktsu.data.room.StudentDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepositoryImpl @Inject constructor(
    private val studentDAO: StudentDAO
) : RoomRepository {
    override suspend fun getStudent(id: String): StudentEntity  {
        Log.e("Impl", "getStudent")
        return studentDAO.readStudent(id)
    }

    override suspend fun getStudents(): List<StudentEntity> =
        studentDAO.readStudents()

    override suspend fun insertStudent(studentEntity: StudentEntity) =
        studentDAO.addStudent(studentEntity)

    override suspend fun updatePhone1(id: Long, phone1: String): Int =
        studentDAO.updatePhone1(id, phone1)

    override suspend fun updatePhone2(id: Long, phone2: String): Int =
        studentDAO.updatePhone2(id, phone2)

    override suspend fun updatePhone3(id: Long, phone3: String): Int =
        studentDAO.updatePhone3(id, phone3)

    override suspend fun updateEmail(id: Long, email: String): Int =
        studentDAO.updateEmail(id, email)
}