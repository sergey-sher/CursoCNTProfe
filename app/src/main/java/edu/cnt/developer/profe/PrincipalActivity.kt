package edu.cnt.developer.profe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridView
import android.widget.Toast
import edu.cnt.developer.profe.an.ANActivity
import edu.cnt.developer.profe.dogs.DogsActivity
import edu.cnt.developer.profe.imc.IMCActivity
import edu.cnt.developer.profe.products.ProductsActivity
import edu.cnt.developer.profe.users.UsersListActivity

class PrincipalActivity : AppCompatActivity() {

    private val menuItems = listOf(
        PrincipalMenuItem("Perros", R.drawable.menu_item_dogs),
        PrincipalMenuItem("Productos", R.drawable.menu_item_products),
        PrincipalMenuItem("Usuarios", R.drawable.menu_item_users),
        PrincipalMenuItem("Navegador", R.drawable.menu_item_browser),
        PrincipalMenuItem("Adivina el numero", R.drawable.menu_item_an),
        PrincipalMenuItem("Índice de masa corporal", R.drawable.menu_item_imc),
        PrincipalMenuItem("Otro", R.drawable.menu_item_other)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        Log.d("MYAPP", "PrincipalActivity: onCreate: start")

        setContentView(R.layout.activity_principal)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val gridView = findViewById<GridView>(R.id.gridViewMenu)
        val adapter = PrincipalMenuAdapter(this, menuItems)
        gridView.adapter = adapter

        Log.d("MYAPP", "PrincipalActivity: onCreate: step 1")
//        Log.d("MYAPP", "PrincipalActivity: onCreate: step 1: menuItems = ${menuItems}")

        gridView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, DogsActivity::class.java))
                1 -> startActivity(Intent(this, ProductsActivity::class.java))
                2 -> startActivity(Intent(this, UsersListActivity::class.java))
                3 -> startActivity(Intent(this, WebViewActivity::class.java))
                4 -> startActivity(Intent(this, ANActivity::class.java))
                5 -> startActivity(Intent(this, IMCActivity::class.java))
                //3 -> Toast.makeText(this, "Abrir camara", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Abrir otro...", Toast.LENGTH_SHORT).show()
            }
        }

        Log.d("MYAPP", "PrincipalActivity: onCreate: step 2")

        //val intent = Intent(this, ProductsActivity::class.java)
        //val intent = Intent(this, DogsActivity::class.java)
        //val intent = Intent(this, UsersListActivity::class.java)
        //startActivity(intent)
        Log.d("MYAPP", "PrincipalActivity: onCreate: finish")

    }

}