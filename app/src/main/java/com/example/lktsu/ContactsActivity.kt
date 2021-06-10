package com.example.lktsu

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lktsu.data.Id
import com.example.lktsu.data.model.StudentEntity
import com.example.lktsu.di.DataStoreScope
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class ContactsActivity : AppCompatActivity() {
    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl
    private lateinit var student: StudentEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        runBlocking(Dispatchers.IO) {
            student = roomRepositoryImpl.getStudent(Id.string)
        }

        val tel1: TextView = findViewById(R.id.Phone1)
        tel1.text = student.phone1// из таблицы student поле tel1 по id = 172016

        val tel2: TextView = findViewById(R.id.Phone2)
        tel2.text =  student.phone2 // из таблицы student поле tel2 по id = 172016

        val tel3: TextView = findViewById(R.id.Phone2)
        tel3.text =  student.phone3// из таблицы student поле tel3 по id = 172016

        val email: TextView = findViewById(R.id.EmailAddress)
        email.text =  student.email// из таблицы student поле email по id = 172016
    }

    fun onClickInfo(view: View?) {
        val text =
            "Для изменения контактных данных введите новую информацию в соответсвующее поле и нажмите кнопку Сохранить"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}