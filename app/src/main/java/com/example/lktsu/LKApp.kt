package com.example.lktsu

import android.app.Application
import com.example.lktsu.data.model.NewsEntity
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

        //Добавляем в цикле все нужные нам данные
        for (student in students) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertStudent(student)
            }
        }
        for(news in newsList) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertNews(news)
            }
        }
    }

    //Тут лежат данные
    companion object Data {
        val students = listOf(
            StudentEntity(
                id = 172016,
                name = "Мадеева Валерия Александровна",
                group = "221071",
                phone1 = "89586639724",
                phone2 = "89651589140",
                email = "madeeva.va@gmail.com"
            )
        )

        val newsList = listOf(
            NewsEntity(
                id = 1,
                title = "Внимание! Кафедра подготовила материалы для проведения испытания по дисциплине Электронные вычислительные машины и периферийные устройства",
                description = "Кафедра подготовила материалы для проведения испытания по дисциплине Электронные вычислительные машины и периферийные устройства. Начало испытания 22.12.2020 00:00:00. Окончание испытания 22.12.2020 23:00:00"
            ),
            NewsEntity(
                id = 2,
                title = "О технических работах в ЛК 12.11.2020 с 17-00 до 18-00",
                description = "12.11.2020 г. с 17-00 до 18-00 будут проводится технические работы на оборудовании, в связи с этим будут наблюдаться перебои в работе системы."
            ),
            NewsEntity(
                id = 3,
                title = "О технических работах в ЛК 11.11.2020 с 17-00 до 18-00",
                description = "11.11.2020 г. с 17-00 до 18-00 будут проводится технические работы на оборудовании, в связи с этим будут наблюдаться перебои в работе системы."
            ),
            NewsEntity(
                id = 4,
                title = "Занятия по физической культуре будут проходить дистанционно с 5.11 до 23.12.",
                description = "Занятия по физической культуре будут проходить дистанционно с 5.11 до 23.12."
            ),
            NewsEntity(
                id = 5,
                title = "О режиме работы кассы",
                description = "Внимание. До 15.10.2020 прием платежей в кассу ТулГУ (гл.корп.) осуществляется в следующем режиме: пн-чт 8.30-16.00, пт - 8.30-15.00, обед 12.12-13.00"
            ),
        )
    }
}