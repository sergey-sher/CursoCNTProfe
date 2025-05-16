package edu.cnt.developer.profe.dogs

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.cnt.developer.profe.R

class DogsGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val raceIntent = intent.getStringExtra(DogsActivity::class.java)
//        Log.d("MYAPP", "")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dogs_gallery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}