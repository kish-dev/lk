package com.example.lktsu

import android.content.Intent
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lktsu.data.Id
import com.example.lktsu.data.model.StudentEntity
import com.example.lktsu.di.DataStoreScope
import com.example.lktsu.repositories.RoomRepositoryImpl
import com.example.lktsu.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.harrix.sqliteexample.DatabaseHelper
import java.io.IOException
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var roomRepositoryImpl: RoomRepositoryImpl

    private lateinit var studentEntity: StudentEntity

    override fun onCreate(savedInstanceState: Bundle?) {

//        var mDBHelper: DatabaseHelper
//        var mDb: SQLiteDatabase

        super.onCreate(savedInstanceState)
        setContentView(com.example.lktsu.R.layout.activity_main)

//        mDBHelper = DatabaseHelper(this)
//
//        try {
//            mDBHelper.updateDataBase()
//        } catch (mIOException: IOException) {
//            throw Error("UnableToUpdateDatabase")
//        }
//
//        mDb = try {
//            mDBHelper.writableDatabase
//        } catch (mSQLException: SQLException) {
//            throw mSQLException
//        }

//        var group: String
//
//        var name = ""
        DataStoreScope.launch(Dispatchers.IO) {
            studentEntity = roomRepositoryImpl.getStudent(Id.long)
        }
//        val cursor: Cursor = mDb.rawQuery("SELECT FIO FROM student", null)
//        cursor.moveToFirst()
//        while (!cursor.isAfterLast()) {
//            name += cursor.getString(1).toString() + " | "
//            cursor.moveToNext()
//        }
//        cursor.close()

        //name = "Мадеева Валерия Александровна" // из таблицы student поле FIO по id = 172016
//        group = "221071" // из таблицы student поле group по id = 172016

        setContentView(com.example.lktsu.R.layout.activity_main)

        val textName: TextView = findViewById(com.example.lktsu.R.id.textName)
        textName.text = studentEntity.name

        val textGroup: TextView = findViewById(com.example.lktsu.R.id.textGroup)
        textGroup.text = studentEntity.group
    }

    fun onClickNews(view: View?) {
        val intent = Intent(this@MainActivity, NewsActivity::class.java)
        startActivity(intent)
    }

    fun onClickSchedule(view: View?) {
        val intent = Intent(this@MainActivity, ScheduleActivity::class.java)
        startActivity(intent)
    }

    fun onClickMarks(view: View?) {
        val intent = Intent(this@MainActivity, MarksActivity::class.java)
        startActivity(intent)
    }

    fun onClickStatements(view: View?) {
        val intent = Intent(this@MainActivity, StatementsActivity::class.java)
        startActivity(intent)
    }

    fun onClickIcon(view: View?) {
        val intent = Intent(this@MainActivity, ContactsActivity::class.java)
        startActivity(intent)
    }

    fun onClickExit(view: View?) {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    fun onClickAbout(view: View?) {
        val text = "Данное приложение является разработкой в рамках ВКР\nстудента Мадеевой В. А. гр. 221071"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun onClickInfo(view: View?) {
        val text = "Для просмотра/изменения контактных данных кликните по изображению над Вашим ФИО"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}
