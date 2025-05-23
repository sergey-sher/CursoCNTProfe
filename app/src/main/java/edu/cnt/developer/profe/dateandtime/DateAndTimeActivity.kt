package edu.cnt.developer.profe.dateandtime

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import edu.cnt.developer.profe.R
import edu.cnt.developer.profe.databinding.ActivityDateAndTimeBinding

class DateAndTimeActivity : AppCompatActivity(), View.OnFocusChangeListener {
    lateinit var binding: ActivityDateAndTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "DateAndTimeActivity: onCreate: start")

        super.onCreate(savedInstanceState)
        binding = ActivityDateAndTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editTextDate.onFocusChangeListener = this
        binding.editTextHour.onFocusChangeListener = this

        Log.d("MYAPP", "DateAndTimeActivity: onCreate: finish")
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        Log.d("MYAPP", "DateAndTimeActivity: onFocusChange: start")

        if (hasFocus) {
            v!!.clearFocus()
            when (v!!.id) {
                R.id.editTextDate -> {
                    Log.d("MYAPP", "Ha tocado la caja de fecha")
                    val dialogDate = SelectDate()
                    dialogDate.show(supportFragmentManager, "CALENDARIO")
                }
                R.id.editTextHour -> {
                    Log.d("MYAPP", "Ha tocado la caja de hora")
                    val dialogClock = SelectHour()
                    dialogClock.show(supportFragmentManager, "CALENDARIO")
                }
            }
        }
        //ocultarTeclado(this)

        Log.d("MYAPP", "DateAndTimeActivity: onFocusChange: finish")
    }

    fun actualizarHoraSeleccionada(newHour:String) : Unit
    {
        binding.editTextHour.setText(newHour)
    }

    fun actualizarFechaSeleccionada(newDate:String) : Unit
    {
        binding.editTextDate.setText(newDate)
    }

}