package edu.cnt.developer.profe.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.cnt.developer.profe.R

class TabsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragment:View? = null
        fragment = inflater.inflate(R.layout.fragment_tabs, container, false)
        val value = arguments?.getInt("TABS_VALUE")
        val tv = fragment.findViewById<TextView>(R.id.textViewTabsFragment)
        tv.text = "VISTA $value"
        return fragment
    }
}