package edu.cnt.developer.profe.dogs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import edu.cnt.developer.profe.utils.NetUtil
import edu.cnt.developer.profe.R
import edu.cnt.developer.profe.databinding.ActivityDogsBinding

class DogsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var selectedRace:String = ""
    lateinit var spinnerRaces: Spinner
    val arrayRaces = arrayOf("affenpinscher", "african", "airedale", "akita", "appenzeller", "australian")
    private lateinit var binding: ActivityDogsBinding
    //var firstTime: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MYAPP", "DogsActivity: onCreate: start")

        //enableEdgeToEdge()

        Log.d("MYAPP", "setting spinner")
        binding = ActivityDogsBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("MYAPP", "Setting spinner")

        this.spinnerRaces = findViewById(R.id.spinnerRaces)
        val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayRaces)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.spinnerRaces.adapter = spinnerAdapter
        //programamos la escucha del spinner
        binding.spinnerRaces.onItemSelectedListener = this

        Log.d("MYAPP", "DogsActivity: onCreate: finish")

    }

    override fun onItemSelected(parent: AdapterView<*>?, opcionTocada: View?, position: Int, id: Long) {
        Log.d("MYAPP", "DogsActivity: onItemSelected: start")

//        if (!this.firstTime) {

        this.selectedRace = (opcionTocada as TextView).text.toString()
        Log.d("MYAPP", "Raza seleccionada = ${this.selectedRace}" )
        //parent?.getItemAtPosition(position)

        Log.d("MYAPP", "Setting snack")
        val snack = Snackbar.make(binding.main, "PERRO SELECCIONADO", BaseTransientBottomBar.LENGTH_LONG)
        snack.setAction("CERRAR") { vista ->Log.d("MYAPP", "Snackbar tocado")}
        snack.setTextColor(getColor(R.color.red))
        snack.show()

//        if (NetUtil.isInternet(this)) {
//
//            Log.d("MYAPP", "Si hay internet")
//            val intentGallery = Intent(this, DogsGalleryActivity::class.java)
//            startActivity(intentGallery)
//        } else {
//            Log.d("MYAPP", "No hay internet")
//            val toastSinConnection = Toast.makeText(this, "No hay conexion", Toast.LENGTH_LONG)
//            toastSinConnection.show()
//        }

//        } else {
//            this.firstTime = false
//        }

        Log.d("MYAPP", "DogsActivity: onItemSelected: finish")

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d("MYAPP", "DogsActivity: onNothingSelected: finish" )
    }

    fun findFotos(view: View) {
        Log.d("MYAPP", "DogsActivity: findFotos: start")
        if (NetUtil.isInternet(this)) {
            Log.d("MYAPP", "Sí hay internet")
            val intentGaleria = Intent(this, DogsGalleryActivity::class.java)
            startActivity(intentGaleria)
        } else {
            Log.d("MYAPP", "No hay internet")
            val toastSinConexion = Toast.makeText(this, "NO HAY CONEXIÓN", Toast.LENGTH_LONG)
            toastSinConexion.show()
        }
        Log.d("MYAPP", "DogsActivity: findFotos: finish")
    }

}