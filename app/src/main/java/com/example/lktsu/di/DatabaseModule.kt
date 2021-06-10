package com.example.lktsu.di

import android.content.Context
import androidx.room.Room
import com.example.lktsu.data.room.*
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        var result: AppDatabase? = null
        result = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lk_for_students.db"
        ).build()

        return result
    }

    @Provides
    fun provideStudentDAO(database: AppDatabase): StudentDAO {
        return database.studentDAO()
    }

    @Provides
    fun provideNewsDAO(database: AppDatabase): NewsDAO {
        return database.newsDAO()
    }


    @Provides
    fun provideStatementDAO(database: AppDatabase): StatementDAO{
        return database.statementDAO()
    }

    @Provides
    fun provideMarksDAO(database: AppDatabase): MarksDAO{
        return database.marksDAO()
    }

    @Provides
    fun provideHistoryDAO(database: AppDatabase): HistoryDAO {
        return database.historyDAO()
    }

    @Provides
    @Singleton
    fun provideRoomRepositoryImpl(
        studentDAO: StudentDAO,
        newsDAO: NewsDAO,
        statementDAO: StatementDAO,
        marksDAO: MarksDAO,
        historyDAO: HistoryDAO
    ): RoomRepositoryImpl =
        RoomRepositoryImpl(studentDAO, newsDAO, statementDAO, marksDAO, historyDAO)

}