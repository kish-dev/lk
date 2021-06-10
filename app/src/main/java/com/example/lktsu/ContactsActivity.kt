package com.example.lktsu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val tel1: TextView = findViewById(R.id.Phone1)
        tel1.setText("89586639724") // из таблицы student поле tel1 по id = 172016

        val tel2: TextView = findViewById(R.id.Phone2)
        tel2.setText("89651589140") // из таблицы student поле tel2 по id = 172016

        val tel3: TextView = findViewById(R.id.Phone2)
        tel3.setText("") // из таблицы student поле tel3 по id = 172016

        val email: TextView = findViewById(R.id.EmailAddress)
        email.setText("madeeva.va@gmail.com") // из таблицы student поле email по id = 172016
    }

    fun onClickInfo(view: View?) {
        val text = "Для изменения контактных данных введите новую информацию в соответсвующее поле и нажмите кнопку Сохранить"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}