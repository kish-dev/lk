package com.example.lktsu

import android.app.Application
import com.example.lktsu.data.model.StudentEntity
import com.example.lktsu.di.DataStoreScope
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@HiltAndroidApp
class LKApp : Application() {

    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl

    override fun onCreate() {
        super.onCreate()

        //Добавляем в цикле всех нужных нам студентов
        for(student in Students.list) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertStudent(student)
            }
        }
    }

    //Тут лежат данные для всех студентов
    companion object Students {
        val list = listOf(
            StudentEntity(
                id = 172016,
                name = "Мадеева Валерия Александровна",
                group = "221071",
                phone1 = "89586639724",
                phone2 = "89651589140",
                email = "madeeva.va@gmail.com"
            )
        )
    }
}