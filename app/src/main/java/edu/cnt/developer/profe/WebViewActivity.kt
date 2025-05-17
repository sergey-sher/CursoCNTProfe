package edu.cnt.developer.profe

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    val urlDefault: String = "https://cntg.xunta.gal"
//    val urlDefault: String = "https://www.google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "WebViewActivity: onCreate: start")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        var webView = findViewById<WebView>(R.id.webView)
        val url = intent?.dataString ?: urlDefault
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        Log.d("MYAPP", "WebViewActivity: onCreate: finish")
    }

}
