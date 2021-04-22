package com.printfulapp.app.dependencyinjection

import com.printfulapp.app.repository.BeersRepository
import com.printfulapp.app.repository.BeersRepositoryImpl
import com.printfulapp.app.utils.ErrorHandler
import org.koin.dsl.module

val repoModule = module {
single <BeersRepository>{
    BeersRepositoryImpl(get())
}

    single {
        ErrorHandler()
    }
}