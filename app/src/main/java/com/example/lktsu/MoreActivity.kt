package com.example.lktsu

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lktsu.data.model.NewsEntity
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MoreActivity : AppCompatActivity() {
    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl

    private lateinit var news: NewsEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        val arguments = intent.extras
        val name = arguments!!["id"].toString().toLong()

        var text: TextView = findViewById(R.id.textViewMore)
        runBlocking(Dispatchers.IO) {
            news = roomRepositoryImpl.getNews(name)
        }
        text.text = news.description
//        if (name == "s1"){
//            text.text = "21.08.2020 16:06 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
//                    "21.08.2020 16:06 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
//                    "03.09.2020 00:04 - К исполнению. Изменение статуса события. Ответственный - Лисицын С.А."
//        }
//        else if (name == "s2"){
//            text.text = "25.01.2021 22:38 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
//                    "25.01.2021 22:38 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
//                    "27.01.2021 09:29 - Аннулировано. Изменение статуса события. Ответственный - Лисицын С.А."
//        }
//        else if (name == "s3"){
//            text.text = "01.06.2021 10:07 - Новое Добавление примечания к событию. Ответственный - Лисицын С.А.. Примечание: бюджет" + "\n\n" +
//                    "01.06.2021 10:07 - Новое Добавление/размножение события. Ответственный - Лисицын С.А." + "\n\n" +
//                    "07.06.2021 15:07 - К исполнению. Изменение статуса события. Ответственный - Лисицын С.А."
//        }
//        else if (name == "1"){
//            text.text = "Кафедра подготовила материалы для проведения испытания по дисциплине Электронные вычислительные машины и периферийные устройства. Начало испытания 22.12.2020 00:00:00. Окончание испытания 22.12.2020 23:00:00"
//        }
//        else if (name == "2"){
//            text.text = "12.11.2020 г. с 17-00 до 18-00 будут проводится технические работы на оборудовании, в связи с этим будут наблюдаться перебои в работе системы."
//        }
//        else if (name == "3"){
//            text.text = "11.11.2020 г. с 17-00 до 18-00 будут проводится технические работы на оборудовании, в связи с этим будут наблюдаться перебои в работе системы."
//        }
//        else if (name == "4"){
//            text.text = "Занятия по физической культуре будут проходить дистанционно с 5.11 до 23.12."
//        }
//        else if (name == "5"){
//            text.text = "Внимание. До 15.10.2020 прием платежей в кассу ТулГУ (гл.корп.) осуществляется в следующем режиме: пн-чт 8.30-16.00, пт - 8.30-15.00, обед 12.12-13.00"
//        }
    }
}