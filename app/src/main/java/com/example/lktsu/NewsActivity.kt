package com.example.lktsu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val nws1: TextView = findViewById(com.example.lktsu.R.id.news1)
        nws1.setText("Внимание! Кафедра подготовила материалы для проведения испытания по дисциплине Электронные вычислительные машины и периферийные устройства")
        val nws2: TextView = findViewById(com.example.lktsu.R.id.news2)
        nws2.setText("О технических работах в ЛК 12.11.2020 с 17-00 до 18-00")
        val nws3: TextView = findViewById(com.example.lktsu.R.id.news3)
        nws3.setText("О технических работах в ЛК 11.11.2020 с 17-00 до 18-00")
        val nws4: TextView = findViewById(com.example.lktsu.R.id.news4)
        nws4.setText("Занятия по физической культуре будут проходить дистанционно с 5.11 до 23.12.")
        val nws5: TextView = findViewById(com.example.lktsu.R.id.news5)
        nws5.setText("О режиме работы кассы")
    }

    fun onClickNews(view: View?) {
        val intent = Intent(this@NewsActivity, MoreActivity::class.java)
        if (view != null) {
            if (view.getId() == R.id.news1) {
                intent.putExtra("id", "n1")
            }
            else if (view.getId() == R.id.news2) {
                intent.putExtra("id", "n2")
            }
            else if (view.getId() == R.id.news3) {
                intent.putExtra("id", "n3")
            }
            else if (view.getId() == R.id.news4) {
                intent.putExtra("id", "n4")
            }
            else if (view.getId() == R.id.news5) {
                intent.putExtra("id", "n5")
            }
        }
        startActivity(intent)
    }

    fun onClickInfo(view: View?) {
        val text = "Для просмотра содержания новости щелкните по ней"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}