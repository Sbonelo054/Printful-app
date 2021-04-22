package com.printfulapp.app.repository

import com.printfulapp.app.model.BeersItem
import com.printfulapp.app.networking.API
import com.printfulapp.app.networking.PrintfulClient
import com.printfulapp.app.utils.ErrorHandler

class BeersRepositoryImpl(val errorHandler: ErrorHandler):BeersRepository {
    lateinit var api: API

    override suspend fun getBeers() : List<BeersItem>?{
        api = PrintfulClient.instance.create(API::class.java)
        return try{
            val results = api.getBeers()
            results
        }catch (e:Exception){
            errorHandler.handle(e)
            null
        }
    }
}