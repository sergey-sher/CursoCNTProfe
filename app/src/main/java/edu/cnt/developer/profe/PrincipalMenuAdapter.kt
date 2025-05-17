package edu.cnt.developer.profe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.ImageView

class PrincipalMenuAdapter(private val context: Context, private val menuItems: List<PrincipalMenuItem>) :
    BaseAdapter() {

    override fun getCount(): Int = menuItems.size

    override fun getItem(position: Int): Any = menuItems[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)

        val item = menuItems[position]
        val imageView = view.findViewById<ImageView>(R.id.imageViewMenuIcon)
        val textView = view.findViewById<TextView>(R.id.textViewMenuTitle)

        imageView.setImageResource(item.iconResId)
        textView.text = item.title

        return view
    }
}
