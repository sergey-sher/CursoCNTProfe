package edu.cnt.developer.profe.dateandtime

import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class SelectDate: DialogFragment(), OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("MYAPP", "SelectDate: onCreateDialog: start")
        var myCalendar: Dialog
        var calendar: Calendar = Calendar.getInstance() // cogemos el calendario actual
        var localYear = calendar.get(Calendar.YEAR) // año actual
        var localMonth = calendar.get(Calendar.MONTH) // mes
        var localDay = calendar.get(Calendar.DATE) // y día actuales

        myCalendar = DatePickerDialog(requireActivity(), this, localYear, localMonth, localDay)

        Log.d("MYAPP", "SelectDate: onCreateDialog: finish")
        return myCalendar
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val finalDate = "$dayOfMonth/${month+1}/${year}"
        Log.d("MYAPP", "Fecha seleccionada = $finalDate")
        (activity as DateAndTimeActivity).actualizarFechaSeleccionada(finalDate)
    }

}