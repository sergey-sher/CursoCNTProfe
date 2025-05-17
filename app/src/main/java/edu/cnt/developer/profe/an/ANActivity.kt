package edu.cnt.developer.profe.an

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.cnt.developer.profe.R
import kotlin.random.Random

class ANActivity : AppCompatActivity() {
    var posibilidades: Int = 5
    var numeroAleatorio: Int = 0

    lateinit var numeroCampo: EditText
    lateinit var campoPosibilidades: TextView
    lateinit var campoResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MYAPP", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_an_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.numeroCampo = findViewById<EditText>(R.id.textViewANNumber)
        this.campoPosibilidades = findViewById<EditText>(R.id.textViewANChances)
        this.campoResultado = findViewById<EditText>(R.id.textViewANMessage)

        this.numeroAleatorio = savedInstanceState?.getInt("NUM_ALEATORIO") ?: Random.Default.nextInt(1, 100)
        this.posibilidades = savedInstanceState?.getInt("NUM_POSIBILIDADES") ?: 5
        Log.d("MYAPP", "Dato: numero = ${numeroAleatorio}")
        this.campoPosibilidades.text = this.posibilidades.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MYAPP", "Start")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MYAPP", "Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MYAPP", "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MYAPP", "Destroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MYAPP", "SaveInstanceState")
        outState.putInt("NUM_POSIBLIDADES", this.posibilidades)
        outState.putInt("NUM_ALEATORIO", this.numeroAleatorio)
    }

    fun check (view: View): Unit {
        Log.d("MYAPP", "ANActivity: check: start")
        var numeroCampo: EditText = findViewById<EditText>(R.id.textViewANNumber)
        var numero: Int = Integer.parseInt(numeroCampo.text.toString())
        var campoPosibilidades: TextView = findViewById<TextView>(R.id.textViewANChances)
        var campoResultado: TextView = findViewById<TextView>(R.id.textViewANMessage)

        if(this.numeroAleatorio == numero){
            campoResultado.text = getString(R.string.an_text_msg_correct)
            //var pantallaCorrecto: Intent = Intent(this, adivinanzaCorrecto::class.java)
            //startActivity(pantallaCorrecto)
            var final: Toast =
                Toast.makeText(this, getString(R.string.an_text_msg_success), Toast.LENGTH_LONG)
            final.show()
            findViewById<Button>(R.id.btnANRestart).visibility = View.VISIBLE
        }else{
            if(numeroAleatorio > numero){
                campoResultado.text = getString(R.string.an_text_msg_wrong_greater)
            }else{
                campoResultado.text = getString(R.string.an_text_msg_wrong_less)
            }
            campoPosibilidades.text = "Posibilidades = ${this.posibilidades}"
            if(this.posibilidades == 0){
                numeroCampo.isEnabled = false;
                var final: Toast = Toast.makeText(this, getString(R.string.an_text_msg_cantplay), Toast.LENGTH_LONG)
                final.show()
                findViewById<Button>(R.id.btnANRestart).visibility = View.VISIBLE
            }
        }
        Log.d("MYAPP", "ANActivity: check: finish")
    }

    fun restartGame(view: View) {
        this.finish()
        this.startActivity(intent)
    }
}