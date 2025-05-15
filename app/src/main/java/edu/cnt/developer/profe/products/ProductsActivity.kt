package edu.cnt.developer.profe.products

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.cnt.developer.profe.NetUtil
import edu.cnt.developer.profe.R
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsActivity : AppCompatActivity() {

    lateinit var productService: ProductsService
    lateinit var productsList: ProductsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productService = retrofit.create(ProductsService::class.java)

        if (NetUtil.isInternet(this)) {
            Log.d("MYAPP", "Hay internet")

            lifecycleScope.launch {
                Log.d("MYAPP", "En corrutina 1")
                productsList = productService.getProducts()
                Log.d("MYAPP", "En corrutina 2 Tamano ${productsList.size}")
                productsList.forEach{
                    product -> Log.d("MYAPP", "Producto ${product}")
                }
            }
            Log.d("MYAPP", "Fuera de corrutina")

        } else {

        }

    }
}