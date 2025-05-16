package edu.cnt.developer.profe.products

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import edu.cnt.developer.profe.utils.NetUtil
import edu.cnt.developer.profe.R
import edu.cnt.developer.profe.databinding.ActivityProductsBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class ProductsActivity : AppCompatActivity() {

    lateinit var prodAdapter: ProductsAdapter
    lateinit var prodService: ProductsService
    lateinit var prodList: ProductsList
    lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        prodService = retrofit.create(ProductsService::class.java)

        if (NetUtil.isInternet(this)) {
            Log.d("MYAPP", "Hay internet")

            lifecycleScope.launch {
                Log.d("MYAPP", "En corrutina 1")
                prodList = prodService.getProducts()
                binding.progressBarProducts.visibility = View.INVISIBLE
                Log.d("MYAPP", "En corrutina 2 Tamano ${prodList.size}")
                prodList.forEach{
                    product -> Log.d("MYAPP", "Producto $product")
                }
                showProductList()
                setSlider()
            }
            Log.d("MYAPP", "Fuera de corrutina")

        } else {
            binding.progressBarProducts.visibility = View.INVISIBLE
            Toast.makeText(this, "SIN CONEXION", Toast.LENGTH_LONG).show()
        }

    }

    private fun setSlider() {
        Log.d("MYAPP", "ProductsActivity: setSlider: start")

        binding.sliderProducts.visibility = View.VISIBLE
        val productPriceMin = prodList.minBy { p -> p.price.toFloat()}
        val productPriceMax = prodList.maxBy { p -> p.price.toFloat()}
        val productPriceAverage = prodList.map { p -> p.price.toFloat()}.average()

        binding.textViewPriceMin.text = productPriceMin.price.toString()
        binding.textViewPriceMax.text = productPriceMax.price.toString()
        binding.textViewPriceAverage.text = productPriceAverage.toString()

        binding.sliderProducts.value = productPriceMin.price.toFloat()
        binding.sliderProducts.valueFrom = productPriceMin.price.toFloat()
        binding.sliderProducts.valueTo = productPriceMax.price.toFloat()

        binding.sliderProducts.setLabelFormatter { price -> price.roundToInt().toString() + " precio max" }
        binding.sliderProducts.addOnChangeListener { slider, valor, fromUser ->
            Log.d("MYAPP", "Valor actual $valor es del usario ? $fromUser")
            var productListFiltered = ProductsList()
            prodList.filter { product -> product.price.toFloat() <= valor }.toCollection(productListFiltered)
            Log.d("MYAPP", "Productos filtrados = $productListFiltered")
            this.prodAdapter.productsList = productListFiltered
            //binding.recViewProducts.adapter = ProductsAdapter(productListFiltered)
            //this.productsAdapter = ProductsAdapter(productsList)
            Log.d("MYAPP", "Valor actual $valor es del usario ? $fromUser")
            this.prodAdapter.notifyDataSetChanged()
            Log.d("MYAPP", "Valor actual $valor es del usario ? $fromUser")
        }

        Log.d("MYAPP", "ProductsActivity: setSlider: finish")
    }

    fun showProductList() {
        Log.d("MYAPP", "ProductsActivity: showProductList: start")
        this.prodAdapter = ProductsAdapter(prodList)
        binding.recViewProducts.adapter = this.prodAdapter
        binding.recViewProducts.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        Log.d("MYAPP", "ProductsActivity: showProductList: finish")
    }
}