package com.printfulapp.app.utils

import android.widget.Toast
import com.printfulapp.app.PrintfulApplication
import retrofit2.HttpException
import java.io.IOException

class ErrorHandler {

    fun handle(exception:Exception){
        when (exception) {
            is HttpException -> {
                    Toast.makeText(PrintfulApplication.activity, exception.message, Toast.LENGTH_LONG).show()
            }
            is IOException -> {
                Toast.makeText(PrintfulApplication.activity, exception.message, Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(PrintfulApplication.activity, exception.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}