package com.example.lktsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class StatementsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statements)

        val btn1: Button = findViewById(com.example.lktsu.R.id.statement1)
        btn1.setText("Повышенная академическая стипендия студента/Повышенная академическая стипендия 3 уровня (выпускники)")

        val btn2: Button = findViewById(com.example.lktsu.R.id.statement2)
        btn2.setText("Повышенная академическая стипендия студента/Повышенная академическая стипендия 3 уровня")

        val btn3: Button = findViewById(com.example.lktsu.R.id.statement3)
        btn3.setText("Заявление на един.мат помощь в связи с необходимостью дорогостоящего лечения и (или) восстановления здоровья")
    }

    fun onClickStatement(view: View?) {
        val intent = Intent(this@StatementsActivity, MoreActivity::class.java)
        if (view != null) {
            if (view.getId() == R.id.statement1) {
                intent.putExtra("id", "s1")
            }
            else if (view.getId() == R.id.statement2) {
                intent.putExtra("id", "s2")
            }
            else if (view.getId() == R.id.statement3) {
                intent.putExtra("id", "s3")
            }
        }
        startActivity(intent)
        }

    fun onClickInfo(view: View?) {
        val text = "Для просмотра истории статусов заявления щелкните по нему"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}