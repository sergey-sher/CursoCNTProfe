package edu.cnt.developer.profe.products

import retrofit2.http.GET

interface ProductsService {
    @GET("miseon920/json-api/products")
    suspend fun getProducts(): ProductsList
}