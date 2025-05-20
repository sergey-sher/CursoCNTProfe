package edu.cnt.developer.profe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import edu.cnt.developer.profe.an.ANActivity
import edu.cnt.developer.profe.imc.IMCActivity
import edu.cnt.developer.profe.users.UsersListActivity
import edu.cnt.developer.profe.products.ProductsActivity
import edu.cnt.developer.profe.dogs.DogsActivity
import edu.cnt.developer.profe.tabs.TabsActivity
import edu.cnt.developer.profe.dateandtime.DateAndTimeActivity

class PrincipalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    var isMenuVisible : Boolean = false // controlar el estado del menú

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "PrincipalActivity: onCreate: start")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        this.drawerLayout = findViewById(R.id.drawerMenuPrincipal)
        this.navigationView = findViewById(R.id.navViewMenuPrincipal)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // para dibujar el icono del menu
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_hamburger) // el icono

        this.navigationView.setNavigationItemSelectedListener(this)

        //Log.d("MYAPP", "PrincipalActivity: onCreate: step 1")
        //Log.d("MYAPP", "PrincipalActivity: onCreate: step 2")
        //val intent = Intent(this, ProductsActivity::class.java)
        //val intent = Intent(this, DogsActivity::class.java)
        //val intent = Intent(this, UsersListActivity::class.java)
        //startActivity(intent)
        Log.d("MYAPP", "PrincipalActivity: onCreate: finish")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MYAPP", "PrincipalActivity: onOptionsItemSelected: start")

        when (item.itemId) {
            android.R.id.home -> {
                Log.d("MYAPP", "Tocado el botón hamburguesa")
                if (this.isMenuVisible)
                {
                    this.drawerLayout.closeDrawers()
                } else {
                    this.drawerLayout.openDrawer(GravityCompat.START)
                }
                this.isMenuVisible = !this.isMenuVisible
            }
        }

        Log.d("MYAPP", "PrincipalActivity: onOptionsItemSelected: finish")
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("MYAPP", "PrincipalActivity: onNavigationItemSelected: start")
        Log.d("MYAPP", "MENÚ LATERAL TOCADO")
        var classObjet : Class<*>? = null
        when (item.order) {
            0 -> {classObjet = VersionsActivity::class.java}
            1 -> {classObjet = ANActivity::class.java}
            2 -> {classObjet = IMCActivity::class.java}
            3 -> {classObjet = UsersListActivity::class.java}
            4 -> {classObjet = WebViewActivity::class.java}
            5 -> {classObjet = ProductsActivity::class.java}
            6 -> {classObjet = DogsActivity::class.java}
            7 -> {classObjet = TabsActivity::class.java}
            8 -> {classObjet = DateAndTimeActivity::class.java}
        }

        this.drawerLayout.closeDrawers()
        val intent = Intent(this, classObjet)
        startActivity(intent)

        Log.d("MYAPP", "PrincipalActivity: onNavigationItemSelected: finish")
        return super.onOptionsItemSelected(item)
    }

}