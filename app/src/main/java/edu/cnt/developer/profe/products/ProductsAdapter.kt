package edu.cnt.developer.profe.products

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.cnt.developer.profe.R

class ProductsAdapter(var productsList: MutableList<ProductsListItem>): RecyclerView.Adapter<ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var productsViewHolder: ProductsViewHolder
        var layoutInflater = LayoutInflater.from(parent.context)
        var filaProduct = layoutInflater.inflate(
            R.layout.item_product_row,
            parent,
            false
        ) // attachToRoot - false !!!
        productsViewHolder = ProductsViewHolder(filaProduct)

        return productsViewHolder
    }

    override fun getItemCount(): Int {
        return this.productsList.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        var product = this.productsList.get(position)
        this.productsList //?
        holder.fillProductsViewHolder(product)
        holder.itemView.tag = position
        holder.itemView.setOnClickListener { row ->
            Log.d("MYAPP", "FILA TOCADA = ${row.tag}")
            this@ProductsAdapter.productsList.removeAt(row.tag as Int)
            this.notifyItemRemoved(row.tag as Int)
            this.printCollectionType(this.productsList)
        }
    }

    fun printCollectionType(c: Collection<*>) {
        when (c) {
            is MutableList -> Log.d("MYAPP", "Es una MutableList")
            is List -> Log.d("MYAPP", "Es una List (inmutable)")
            is MutableSet -> Log.d("MYAPP", "Es una MutableSet")
            is MutableMap<*, *> -> Log.d("MYAPP", "Es una MutableMap")
            is Map<*, *> -> Log.d("MYAPP", "Es un Map (inmutable)")
            else -> Log.d("MYAPP", "Otro tipo de coleccion")
        }
    }

}