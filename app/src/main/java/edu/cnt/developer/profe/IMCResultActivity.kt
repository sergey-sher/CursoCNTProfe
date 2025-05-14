package edu.cnt.developer.profe

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IMCResultActivity : AppCompatActivity() {

    lateinit var textResult: TextView // = findViewById<>(R.id.textIMC)
    lateinit var viewResult: ImageView // = findViewById<>(R.id.imageIMC)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_resultado_activity)

        val resultIMCNumerico = intent.getFloatExtra("IMC_RESULT", 0f)
        Log.d("MYAPP", "onCreate: Getting IMC_RESULT => ${resultIMCNumerico}")

        this.textResult = findViewById(R.id.textIMC)
        this.viewResult = findViewById(R.id.imageIMC)

        when {
            resultIMCNumerico < 16 -> {
                // TipoIMC.DESNUTRIDO.toString()
                this.showResult(R.drawable.imc_undernourished, IMCTypes.DESNUTRIDO.toString())
            }
            resultIMCNumerico >= 16 && resultIMCNumerico < 18 -> {
                this.showResult(R.drawable.imc_thin, IMCTypes.DELGADO.toString())
            }
            resultIMCNumerico >= 18 && resultIMCNumerico < 25 -> {
                this.showResult(R.drawable.imc_perfect, IMCTypes.IDEAL.toString())
            }
            resultIMCNumerico >= 25 && resultIMCNumerico < 31 -> {
                this.showResult(R.drawable.imc_overweight, IMCTypes.SOBREPESO.toString())
            }
            resultIMCNumerico >= 31 -> {
                this.showResult(R.drawable.imc_obese, IMCTypes.OBESO.toString())
            }
        }

    }
    fun showResult(imageIMC: Int, textIMC: String): Unit {
        this.viewResult.setImageResource(imageIMC)
        this.textResult.text = textIMC
        Log.d("MYAPP", "showResult: RES = ${textIMC}")

    }

}