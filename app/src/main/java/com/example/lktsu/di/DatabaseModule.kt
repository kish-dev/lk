package com.example.lktsu.di

import android.content.Context
import androidx.room.Room
import com.example.lktsu.data.room.AppDatabase
import com.example.lktsu.data.room.StudentDAO
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
            "Students2.db"
        ).build()

        return result
    }

    @Provides
    fun provideStudentDAO(database: AppDatabase): StudentDAO {
        return database.studentDAO()
    }

    @Provides
    @Singleton
    fun provideRoomRepositoryImpl(
        studentDAO: StudentDAO
    ): RoomRepositoryImpl =
        RoomRepositoryImpl(studentDAO)

}