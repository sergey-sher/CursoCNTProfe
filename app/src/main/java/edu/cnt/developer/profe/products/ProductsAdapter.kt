package edu.cnt.developer.profe.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.cnt.developer.profe.R

class ProductsAdapter(var productsList: ProductsList): RecyclerView.Adapter<ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var productsViewHolder: ProductsViewHolder
        var layoutInflater = LayoutInflater.from(parent.context)
        var filaProduct = layoutInflater.inflate(R.layout.item_product_row, parent, false) // attachToRoot - false !!!
        productsViewHolder = ProductsViewHolder(filaProduct)

        return productsViewHolder
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        var product = productsList.get(position)
        holder.fillProductsViewHolder(product)
    }

    override fun getItemCount(): Int {
        return this.productsList.size
    }

}