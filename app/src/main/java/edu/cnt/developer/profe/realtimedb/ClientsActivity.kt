package edu.cnt.developer.profe.realtimedb

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import edu.cnt.developer.profe.R

const val URL_DATABASE = "https://cursocnt-5a099-default-rtdb.asia-southeast1.firebasedatabase.app/"

class ClientsActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYAPP", "ClientsActivity: onCreate: start")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_clients)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        this.databaseReference = FirebaseDatabase.getInstance(URL_DATABASE).reference
        Log.d("MYAPP", "ClientsActivity: onCreate: finish")
    }

    fun createClient(view: View) {
        Log.d("MYAPP", "ClientsActivity: crearCliente: start")
        val nombre = findViewById<EditText>(R.id.editTextClientsName).text.toString()
        val edad = findViewById<EditText>(R.id.editTextClientsAge).text.toString().toLong()

        var cliente = Client(edad, nombre)
        //genero clave
        var idclave = this.databaseReference.push().key
        cliente.clave = idclave!!
        //inserto
        this.databaseReference.child("clientes").child(idclave).setValue(cliente).addOnCompleteListener {
                tarea -> Toast.makeText(this, "CLIENTE INSERTADO FIN", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
                exception ->
            Toast.makeText(this, "ERROR AL INSERTAR EL CLIENTE", Toast.LENGTH_LONG).show()
            Log.e("MYAPP", "ERROR!", exception)
        }
        Log.d("MYAPP", "ClientsActivity: crearCliente: finish")
    }

    fun btnClientsListClientsDB(view: View) {

    }

}