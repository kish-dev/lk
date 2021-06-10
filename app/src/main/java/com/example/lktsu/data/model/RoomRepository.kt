package com.example.lktsu.data.model

interface RoomRepository {
    suspend fun getStudent(id: Long): StudentEntity
    suspend fun getStudents(): List<StudentEntity>
    suspend fun insertStudent(studentEntity: StudentEntity)
    suspend fun updatePhone1(id: Long, phone1: String): Int
    suspend fun updatePhone2(id: Long, phone2: String): Int
    suspend fun updatePhone3(id: Long, phone3: String): Int
    suspend fun updateEmail(id: Long, email: String): Int

    suspend fun getNewsList(): List<NewsEntity>
    suspend fun getNews(id: Long): NewsEntity
    suspend fun insertNews(newsEntity: NewsEntity)

    suspend fun getStatementList(): List<StatementEntity>
    suspend fun getStatement(id: Long): StatementEntity
    suspend fun insertStatement(statementEntity: StatementEntity)

    suspend fun getStudentMarks(studentId: Long): List<MarksEntity>
    suspend fun insertMark(marksEntity: MarksEntity)
    suspend fun getSemesterMarks(studentId: Long, semester: Long): List<MarksEntity>
    suspend fun getStudentMarksForSubject(
        studentId: Long,
        subject: String,
        semester: Int
    ): MarksEntity

    suspend fun insertHistory(historyEntity: HistoryEntity)
    suspend fun getHistory(number: Long): HistoryEntity
}
