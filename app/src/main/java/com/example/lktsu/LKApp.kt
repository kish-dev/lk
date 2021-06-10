package com.example.lktsu

import android.app.Application
import com.example.lktsu.data.Id
import com.example.lktsu.data.model.MarksEntity
import com.example.lktsu.data.model.NewsEntity
import com.example.lktsu.data.model.StatementEntity
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

        for (news in newsList) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertNews(news)
            }
        }

        for (statement in statementList) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertStatement(statement)
            }
        }

        for (mark in marksList) {
            DataStoreScope.launch(Dispatchers.IO) {
                roomRepositoryImpl.insertMark(mark)
            }
        }
    }

    // Тут лежат данные(можно удалить, загружаются только раз для каждого телефона,
    // потом хранятся в базе данных
    companion object Data {
        val students = listOf(
            StudentEntity(
                id = Id.long,
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

        val statementList = listOf(
            StatementEntity(
                id = 1,
                title = "Повышенная академическая стипендия студента/Повышенная академическая стипендия 3 уровня (выпускники)",
                description = "21.08.2020 16:06 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
                        "21.08.2020 16:06 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
                        "03.09.2020 00:04 - К исполнению. Изменение статуса события. Ответственный - Лисицын С.А.",
                student_id = Id.long,
                number = 1,
                status = ""
            ),
            StatementEntity(
                id = 2,
                title = "Повышенная академическая стипендия студента/Повышенная академическая стипендия 3 уровня",
                description = "25.01.2021 22:38 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
                        "25.01.2021 22:38 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
                        "27.01.2021 09:29 - Аннулировано. Изменение статуса события. Ответственный - Лисицын С.А.",
                student_id = Id.long,
                number = 2,
                status = ""
            ),
            StatementEntity(
                id = 3,
                title = "Заявление на един.мат помощь в связи с необходимостью дорогостоящего лечения и (или) восстановления здоровья",
                description = "01.06.2021 10:07 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
                        "01.06.2021 10:07 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
                        "07.06.2021 15:07 - К исполнению. Изменение статуса события. Ответственный - Лисицын С.А.",
                student_id = Id.long,
                number = 3,
                status = ""
            )
        )

        val marksList = listOf(
            MarksEntity(
                id = 1,
                student_id = Id.long,
                subject = "Всеобщая история",
                mark = "Зачет",
                semester = 1,
                event = "зч"
            ),
            MarksEntity(
                id = 2,
                student_id = Id.long,
                subject = "Иностранный язык",
                mark = "Зачет",
                semester = 1,
                event = "зч"
            ),
            MarksEntity(
                id = 3,
                student_id = Id.long,
                subject = "Информатика",
                mark = "5",
                semester = 1,
                event = "ДЗ"
            ),
            MarksEntity(
                id = 4,
                student_id = Id.long,
                subject = "История России",
                mark = "5",
                semester = 1,
                event = "Э"
            ),
            MarksEntity(
                id = 5,
                student_id = Id.long,
                subject = "Математика",
                mark = "4",
                semester = 1,
                event = "Э"
            ),
            MarksEntity(
                id = 6,
                student_id = Id.long,
                subject = "Правоведение и противодействии коррупции",
                mark = "Зачет",
                semester = 1,
                event = "зч"
            ),
            MarksEntity(
                id = 7,
                student_id = Id.long,
                subject = "Управление проектной деятельностью и бизнес-планирование",
                mark = "5",
                semester = 1,
                event = "ДЗ"
            ),
            MarksEntity(
                id = 8,
                student_id = Id.long,
                subject = "Физическая культура и спорт",
                mark = "Зачет",
                semester = 1,
                event = "зч"
            ),
            MarksEntity(
                id = 9,
                student_id = Id.long,
                subject = "Базы данных",
                mark = "5",
                semester = 6,
                event = "КР"
            ),
            MarksEntity(
                id = 10,
                student_id = Id.long,
                subject = "Базы данных",
                mark = "5",
                semester = 6,
                event = "Э"
            ),
            MarksEntity(
                id = 11,
                student_id = Id.long,
                subject = "Математическое моделирование экономических систием",
                mark = "5",
                semester = 6,
                event = "ДЗ"
            ),
            MarksEntity(
                id = 12,
                student_id = Id.long,
                subject = "Научно-исследовательская работа",
                mark = "5",
                semester = 6,
                event = "ДЗ"
            ),
            MarksEntity(
                id = 13,
                student_id = Id.long,
                subject = "Основы информационной безопасности экономических систем",
                mark = "Зачет",
                semester = 6,
                event = "зч"
            ),
            MarksEntity(
                id = 14,
                student_id = Id.long,
                subject = "Предметно-ориентированные информационные системы в менеджменте",
                mark = "5",
                semester = 6,
                event = "Э"
            ),
            MarksEntity(
                id = 15,
                student_id = Id.long,
                subject = "Проектирование информационных систем",
                mark = "Зачет",
                semester = 6,
                event = "зч"
            ),
            MarksEntity(
                id = 16,
                student_id = Id.long,
                subject = "Социально-экономическая статистика",
                mark = "5",
                semester = 6,
                event = "Э"
            ),
            MarksEntity(
                id = 17,
                student_id = Id.long,
                subject = "Физическая культура и спорт (элективные модули)",
                mark = "Зачет",
                semester = 6,
                event = "зч"
            ),
            MarksEntity(
                id = 18,
                student_id = Id.long,
                subject = "Эконометрика",
                mark = "5",
                semester = 6,
                event = "Э"
            ),
        )
    }
}