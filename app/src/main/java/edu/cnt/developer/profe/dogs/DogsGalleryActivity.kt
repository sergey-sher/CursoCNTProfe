package edu.cnt.developer.profe.dogs

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.cnt.developer.profe.databinding.ActivityDogsGalleryBinding
import edu.cnt.developer.profe.utils.NetUtil
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogsGalleryActivity : AppCompatActivity() {

    lateinit var binding : ActivityDogsGalleryBinding
    lateinit var dogsService: DogsService
    lateinit var dogsList: DogsList
    var dogsBreed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "DogsGalleryActivity: onCreate: start")
        super.onCreate(savedInstanceState)
        this.dogsBreed = intent.getStringExtra("DOGS_BREED") ?: ""
        Log.d("MYAPP", "DogsGalleryActivity.dogsBreed = ${this.dogsBreed}")

        binding = ActivityDogsGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewDogsBreed.text = dogsBreed
        getPhotos()
        Log.d("MYAPP", "DogsGalleryActivity: onCreate: finish")
    }

    private fun getPhotos() {
        Log.d("MYAPP", "DogsGalleryActivity: getPhotos: start")

        val url = "https://dog.ceo/"
        Log.d("MYAPP", "DogsGalleryActivity: onCreate: dogsBreed = $dogsBreed")
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dogsService = retrofit.create(DogsService::class.java)

        if (NetUtil.isInternet(this)) {
            Log.d("MYAPP", "DogsGalleryActivity: getPhotos: Hay internet")

            lifecycleScope.launch {
                Log.d("MYAPP", "En corrutina 1")
                dogsList = dogsService.getDogsListByBreed(this@DogsGalleryActivity.dogsBreed)
                Log.d("MYAPP", "Número de fotos = ${dogsList.message.size}")
                showPhotos()
            }

        } else {
            Toast.makeText(
                this,
                "DogsGalleryActivity: getPhotos: SIN ACCESO A INTERNET",
                Toast.LENGTH_LONG
            ).show()
        }

        Log.d("MYAPP", "DogsGalleryActivity: getPhotos: finish")
    }

    private fun showPhotos() {
        Log.d("MYAPP", "DogsGalleryActivity: showPhotos: Mostrar fotos")
        var dogsFragmentAdapter = DogsFragmentAdapter(this)
        dogsFragmentAdapter.dogsList = this.dogsList
        binding.viewPagerDogs.adapter = dogsFragmentAdapter
    }

}