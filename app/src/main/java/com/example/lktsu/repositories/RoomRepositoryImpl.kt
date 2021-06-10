package com.example.lktsu.repositories

import android.util.Log
import com.example.lktsu.data.model.NewsEntity
import com.example.lktsu.data.model.RoomRepository
import com.example.lktsu.data.model.StatementEntity
import com.example.lktsu.data.model.StudentEntity
import com.example.lktsu.data.room.NewsDAO
import com.example.lktsu.data.room.StatementDAO
import com.example.lktsu.data.room.StudentDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepositoryImpl @Inject constructor(
    private val studentDAO: StudentDAO,
    private val newsDAO: NewsDAO,
    private val statementDAO: StatementDAO
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

    override suspend fun getNewsList(): List<NewsEntity> =
        newsDAO.readNewsList()

    override suspend fun getNews(id: Long): NewsEntity =
        newsDAO.readNews(id)

    override suspend fun insertNews(newsEntity: NewsEntity) =
        newsDAO.addNews(newsEntity)

    override suspend fun getStatementList(): List<StatementEntity> =
        statementDAO.readStatementList()

    override suspend fun getStatement(id: Long): StatementEntity =
        statementDAO.readStatement(id)

    override suspend fun insertStatement(statementEntity: StatementEntity) =
        statementDAO.addStatement(statementEntity)
}