package edu.cnt.developer.profe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.util.Log
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
        setContentView(R.layout.activity_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        * imc = PESO (KG) /  ALTURA * ALTURA
        * IMC < 16 -> desnutridos
        * IMC >=16 y <18 -> delgados
        * IMC >=18 y <25 -> ideal
        * IMC >=25 Y <31 -> sobrepeso
        * IMC >=31 -> obeso
        */

    }

    fun CalcularIMC(view: View) {
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

            val intentResult: Intent = Intent(this, ResultadoIMCActivity::class.java)
            intentResult.putExtra("IMC_RESULT", indexIMC)
            Log.d("MYAPP", "CalcularIMC: Putting ${indexIMC} to IMC_RESULT")
            startActivity(intentResult)

        }

    }

}