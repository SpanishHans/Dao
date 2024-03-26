package edu.app.dao

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class BrowserActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_browser)

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // Enable JavaScript
        webView.loadUrl("https://www.google.com") // Load a web page
    }
}