package com.example.lktsu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lktsu.data.model.NewsEntity
import com.example.lktsu.repositories.RoomRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl
    private lateinit var news: List<NewsEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        runBlocking(Dispatchers.IO) {
            news = roomRepositoryImpl.getNewsList()
        }

        val nws1: TextView = findViewById(com.example.lktsu.R.id.news1)
        nws1.text = news[0].title
        val nws2: TextView = findViewById(com.example.lktsu.R.id.news2)
        nws2.text = news[1].title
        val nws3: TextView = findViewById(com.example.lktsu.R.id.news3)
        nws3.text = news[2].title
        val nws4: TextView = findViewById(com.example.lktsu.R.id.news4)
        nws4.text = news[3].title
        val nws5: TextView = findViewById(com.example.lktsu.R.id.news5)
        nws5.text = news[4].title
    }

    fun onClickNews(view: View?) {
        val intent = Intent(this@NewsActivity, MoreActivity::class.java)
        if (view != null) {
            if (view.getId() == R.id.news1) {
                intent.putExtra("type", "news")
                intent.putExtra("id", "1")
            }
            else if (view.getId() == R.id.news2) {
                intent.putExtra("type", "news")
                intent.putExtra("id", "2")
            }
            else if (view.getId() == R.id.news3) {
                intent.putExtra("type", "news")
                intent.putExtra("id", "3")
            }
            else if (view.getId() == R.id.news4) {
                intent.putExtra("type", "news")
                intent.putExtra("id", "4")
            }
            else if (view.getId() == R.id.news5) {
                intent.putExtra("type", "news")
                intent.putExtra("id", "5")
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