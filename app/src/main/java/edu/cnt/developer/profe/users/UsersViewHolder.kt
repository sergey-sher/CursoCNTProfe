package edu.cnt.developer.profe.users

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.cnt.developer.profe.R

class UsersViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    val userName: TextView = itemView.findViewById(R.id.userName)
    val userAge: TextView = itemView.findViewById(R.id.userAge)
    fun fillUserViewHolder(user: User) {
        this.userName.text = user.name
        this.userAge.text = user.age.toString()
    }

}