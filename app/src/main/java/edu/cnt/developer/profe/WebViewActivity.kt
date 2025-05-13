package edu.cnt.developer.profe

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

//    val urlRemote: String = "https://cntg.xunta.gal"
//    val urlRemote: String = "https://www.google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        var webView = findViewById<WebView>(R.id.webView)
        val url = intent?.dataString ?: "https://cntg.xunta.gal/"
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
//        webView.loadUrl(urlRemote)

    }

}
