package edu.cnt.developer.profe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val remoteUrl:String = "https://cntg.xunta.gal/"
        val intent = Intent(this, WebViewActivity::class.java)
        intent.data = Uri.parse(remoteUrl)
        startActivity(intent)
//        val intentImplicito = Intent(Intent.ACTION_VIEW, Uri.parse(remoteUrl))
//        startActivity(intentImplicito)
    }

}