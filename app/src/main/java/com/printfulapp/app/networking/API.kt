package com.printfulapp.app.networking
import com.printfulapp.app.model.BeersItem
import retrofit2.http.GET

interface API {

    @GET("beers")
    suspend fun getBeers() : List<BeersItem>
}