package edu.cnt.developer.profe.dogs

import retrofit2.http.GET
import retrofit2.http.Path

interface DogsService {
    @GET("api/breed/{breed}/images")
    suspend fun getDogsListByBreed(@Path("breed") race: String): DogsList
}