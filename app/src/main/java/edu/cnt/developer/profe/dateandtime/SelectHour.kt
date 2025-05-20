package edu.cnt.developer.profe.dateandtime

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class SelectHour: DialogFragment(), OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("MYAPP", "SelectHour: onCreateDialog: start")
        var dialogClock: Dialog
        var calendar: Calendar = Calendar.getInstance()
        var localHour = calendar.get(Calendar.HOUR_OF_DAY)
        var localMinute = calendar.get(Calendar.MINUTE)

        dialogClock = TimePickerDialog(requireActivity(), this, localHour, localMinute, true)

        Log.d("MYAPP", "SelectHour: onCreateDialog: finish")
        return dialogClock
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Log.d("MYAPP", "SelectHour: onTimeSet: start")
        val horaFinal: String
        val localHour: String
        val localMinute: String

        localHour = if (hourOfDay < 10) "0$hourOfDay" else hourOfDay.toString()
        localMinute = if (minute < 10) "0$minute" else minute.toString()
        horaFinal = "$localHour:$localMinute"

        (activity as DateAndTimeActivity).actualizarHoraSeleccionada(horaFinal)
        Log.d("MYAPP", "SelectHour: onTimeSet: finish")
    }

}