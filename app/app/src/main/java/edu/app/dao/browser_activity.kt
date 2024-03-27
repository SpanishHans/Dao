package edu.app.dao

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import edu.app.dao.databinding.LoginToAppLayoutBinding
import edu.app.dao.databinding.WebBrowserBinding

class BrowserActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    /*
        Declaración del binding con el layout web_browser
        El nombre WebBrowserBinding sale del archivo .xml
        mencionado anteriormente y se genera automáticamente.
     */
    private lateinit var binding: WebBrowserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Se utiliza el binding para inflar la vista y meterse como raiz
        binding = WebBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webView = binding.webView
        webView.settings.javaScriptEnabled = true // Enable JavaScript
        webView.loadUrl("https://www.google.com") // Load a web page
    }
}