package com.example.lktsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.lktsu.data.model.StatementEntity
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class StatementsActivity : AppCompatActivity() {
    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl
    lateinit var statementList: List<StatementEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statements)

        val btn1: Button = findViewById(com.example.lktsu.R.id.statement1)
        runBlocking(Dispatchers.IO) {
            statementList = roomRepositoryImpl.getStatementList()
        }
        btn1.text = statementList[0].title

        val btn2: Button = findViewById(com.example.lktsu.R.id.statement2)
        btn2.text = statementList[1].title

        val btn3: Button = findViewById(com.example.lktsu.R.id.statement3)
        btn3.text = statementList[2].title
    }

    fun onClickStatement(view: View?) {
        val intent = Intent(this@StatementsActivity, MoreActivity::class.java)
        if (view != null) {
            if (view.getId() == R.id.statement1) {
                intent.putExtra("type", "statement")
                intent.putExtra("id", "1")
            }

            else if (view.getId() == R.id.statement2) {
                intent.putExtra("type", "statement")
                intent.putExtra("id", "2")
            }
            else if (view.getId() == R.id.statement3) {
                intent.putExtra("type", "statement")
                intent.putExtra("id", "3")
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