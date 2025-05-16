package edu.cnt.developer.profe.products

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.cnt.developer.profe.R

class ProductsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    val productId: TextView = itemView.findViewById(R.id.textViewProductId)
    val productName: TextView = itemView.findViewById(R.id.textViewProductName)
    val productPrice: TextView = itemView.findViewById(R.id.textViewProductPrice)
    val image: ImageView = itemView.findViewById(R.id.imageViewProductImage)

    fun fillProductsViewHolder(product: ProductsListItem) {
        productId.text = product.id.toString()
        productName.text = product.name
        productPrice.text = product.price.toString()
        Picasso.get().load(product.imageUrl).error(R.mipmap.ic_launcher).into(image)
    }

}