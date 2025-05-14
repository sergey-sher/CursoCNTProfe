package edu.cnt.developer.profe

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlin.math.absoluteValue
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.roundToInt

class IMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_imc, menu)//ya pinto el menú
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MYAPP", "onOptionsItemSelected: Menu app bar tocado': ${item.itemId} ${item.title} ${item.itemId}")
        when (item.itemId)
        {
            R.id.opcionLimpiar -> {
                Log.d("MYAPP", "onOptionsItemSelected: Ha tocado la opcion de limpiar")
                this.limpiaFormulario()
            }
            R.id.opcionSalir -> {
                Log.d("MYAPP", "onOptionsItemSelected: Ha tocado la opcion de salir")
                this.finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun calcularIMC(view: View) {
        if (view.id == R.id.buttonCalcular) {
            Log.d("MYAPP", "CalcularIMC: El usario ha tocado al boton 'Calcular IMC': ${view.id}")
            Log.d("MYAPP", "CalcularIMC: absolute = ${R.id.buttonCalcular.absoluteValue}")

            val weight : Float = findViewById<EditText>(R.id.editTextWeight).text.toString().toFloat()
            val height : Float = findViewById<EditText>(R.id.editTextHeight).text.toString().toFloat()
            val indexIMC = weight / (height * height)

            var userMessage = "Su IMC es = ${indexIMC.roundToInt()}"
            Log.d("MYAPP", "CalcularIMC: ${userMessage}")

            var textIMC: String = ""
            if (indexIMC < 16)
                textIMC = "Usted está desnutrido"
            else if (indexIMC < 18)
                textIMC = "Usted está un poco delgado"
            else if (indexIMC < 25)
                textIMC = "Usted está en perfecta forma"
            else if (indexIMC < 31)
                textIMC = "Usted tiene un poco sobrepeso"
            else
                textIMC = "Usted está gordo"
            Log.d("MYAPP", "CalcularIMC: Su resultado es - ${textIMC}")

            userMessage += ": ${textIMC}"
            Log.d("MYAPP", "CalcularIMC: ${userMessage}")
            val notiToast: Toast = Toast.makeText(this, userMessage, Toast.LENGTH_LONG)
            notiToast.show()

            val intentResult: Intent = Intent(this, IMCResultActivity::class.java)
            intentResult.putExtra("IMC_RESULT", indexIMC)
            Log.d("MYAPP", "CalcularIMC: Putting ${indexIMC} to IMC_RESULT")
            startActivity(intentResult)

        }

    }

    private fun limpiaFormulario() {
        findViewById<EditText>( R.id.editTextWeight).text.clear()
        findViewById<EditText>( R.id.editTextHeight).text.clear()
    }

    private fun salirApp() {
        //this.finish()
        var dialogo = AlertDialog.Builder(this)
            .setTitle("SALIR")
            .setMessage("Desea salir?")
            .setNegativeButton("NO") {
                dialog: DialogInterface, opcion: Int ->
                    dialog.cancel()
            }
            .setPositiveButton("SÍ"){
                    dialog, opcion -> this.finish()
            }
        dialogo.show()
    }

}