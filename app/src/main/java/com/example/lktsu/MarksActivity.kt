package com.example.lktsu

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MarksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.example.lktsu.R.layout.activity_marks)

        var smstr: Array<String> = arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8"
        )

        //вывод ср. балла диплома
        var mid: TextView = findViewById(com.example.lktsu.R.id.ball)
        mid.setText("4.925")

        //выпадающий список семестров
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, smstr)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        var spinner: Spinner = findViewById(com.example.lktsu.R.id.spinner)
        spinner.setAdapter(aa)

        var textView: TextView

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View?, selectedItemPosition: Int, selectedId: Long
            ) {
                if (smstr[selectedItemPosition] == "1"){
                    // из таблицы marks выбрать поля subjects + KM заносить в textView sbjc,
                        // а поля mark в textView mrk
                            // и так для различных семестров
                    textView = findViewById(com.example.lktsu.R.id.sbjct1)
                    textView.setText("Всеобщая история (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk1)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct2)
                    textView.setText("Иностранный язык (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk2)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct3)
                    textView.setText("Информатика (ДЗ)")
                    textView = findViewById(com.example.lktsu.R.id.mrk3)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct4)
                    textView.setText("История России (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk4)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct5)
                    textView.setText("Математика (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk5)
                    textView.setText("4")
                    textView = findViewById(com.example.lktsu.R.id.sbjct6)
                    textView.setText("Правоведение и противодействие коррупции (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk6)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct7)
                    textView.setText("Управление проектной деятельностью и бизнес-планирование (ДЗ)")
                    textView = findViewById(com.example.lktsu.R.id.mrk7)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct8)
                    textView.setText("Физическая культура и спорт (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk8)
                    textView.setText("Зачет")
                }
                else if (smstr[selectedItemPosition] == "6"){
                    textView = findViewById(com.example.lktsu.R.id.sbjct1)
                    textView.setText("Базы данных (КР)")
                    textView = findViewById(com.example.lktsu.R.id.mrk1)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct2)
                    textView.setText("Базы данных (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk2)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct3)
                    textView.setText("Математическое моделирование экономических систем (ДЗ)")
                    textView = findViewById(com.example.lktsu.R.id.mrk3)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct4)
                    textView.setText("Научно-исследовательская работа (ДЗ)")
                    textView = findViewById(com.example.lktsu.R.id.mrk4)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct5)
                    textView.setText("Основы информационной безопасности экономических систем (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk5)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct6)
                    textView.setText("Предметно-ориентированные информационные системы в менеджменте (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk6)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct7)
                    textView.setText("Проектирование информационных систем (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk7)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct8)
                    textView.setText("Социально-экономическая статистика (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk8)
                    textView.setText("5")
                    textView = findViewById(com.example.lktsu.R.id.sbjct7)
                    textView.setText("Физическая культура и спорт (элективные модули) (зч)")
                    textView = findViewById(com.example.lktsu.R.id.mrk7)
                    textView.setText("Зачет")
                    textView = findViewById(com.example.lktsu.R.id.sbjct8)
                    textView.setText("Эконометрика (Э)")
                    textView = findViewById(com.example.lktsu.R.id.mrk8)
                    textView.setText("5")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun onClickInfo(view: View?) {
        val text = "Для просмотра результатов за другие семестры щелкните по номеру и выберите нужный из выпадающего списка"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}