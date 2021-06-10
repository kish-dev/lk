package com.example.lktsu

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class ScheduleActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        webView = findViewById (R.id.webView)

        // включение поддержки JavaScript
        webView.getSettings().setJavaScriptEnabled(true)

        //загрузка страницы по url
        webView.loadUrl("http://schedule.tsu.tula.ru/?group=221071")
    }

    private class SimpleWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            return false
        }
    }

    //возвращение к предыдущей странице
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}