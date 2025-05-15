package edu.cnt.developer.profe

import android.content.Context
import android.net.ConnectivityManager

object NetUtil {

    fun isInternet(context: Context): Boolean {

        var isInt = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isInt = (cm.activeNetwork != null)

        return isInt
    }
}