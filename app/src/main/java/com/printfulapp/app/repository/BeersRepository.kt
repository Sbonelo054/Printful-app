package com.printfulapp.app.repository

import com.printfulapp.app.model.Beers
import com.printfulapp.app.model.BeersItem

interface BeersRepository {

   suspend fun getBeers(): List<BeersItem>?
}