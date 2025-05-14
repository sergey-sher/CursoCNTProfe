package edu.cnt.developer.profe

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UsersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_users_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("MYAPP", "UsersListActivity: onCreate: start")

        var user1: User = User("Vale", 42)
        var user2: User = User("Pepa", 18)
        var user3: User = User("Jose", 32)
        var user4: User = User("Juani", 15)
        var user5: User = User("Manolo", 75)

        var listUsers = listOf(user1, user2, user3, user4, user5)

        Log.d("MYAPP", "UsersListActivity: onCreate: List of users = ${listUsers}")

        var recView = findViewById<RecyclerView>(R.id.usersListRecView)

        //adapter
        Log.d("MYAPP", "UsersListActivity: onCreate: Attaching the adapter")
        var adapterUsers = UsersAdapter(listUsers)
        recView.adapter = adapterUsers

        Log.d("MYAPP", "UsersListActivity: onCreate: Using the adapter")
        var layoutRecycler: RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false )
        //var layoutRecycler : RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false )
        //var layoutRecycler : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        Log.d("MYAPP", "UsersListActivity: onCreate: Using the adapter 2")
        recView.layoutManager = layoutRecycler

        Log.d("MYAPP", "UsersListActivity: onCreate: finish")

    }

}