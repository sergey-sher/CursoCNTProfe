package edu.cnt.developer.profe.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.cnt.developer.profe.R

class UsersAdapter(var usersList: List<User>): RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        var userViewHolder: UsersViewHolder
        var layoutInflater = LayoutInflater.from(parent.context)
        var filaUsuario = layoutInflater.inflate(R.layout.fila_usuario, parent, false) // attachToRoot - false !!!
        userViewHolder = UsersViewHolder(filaUsuario)

        return userViewHolder
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        var user = usersList.get(position)
        holder.fillUserViewHolder(user)
    }

    override fun getItemCount(): Int {
        return this.usersList.size
    }

}