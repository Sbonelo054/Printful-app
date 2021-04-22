package com.printfulapp.app.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PrintfulClient {

    private val BASE_URL = "https://api.punkapi.com/v2/"

    private var backingInstance: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    var instance: Retrofit = backingInstance
}