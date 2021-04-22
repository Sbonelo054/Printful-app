package com.printfulapp.app.dependencyinjection

import com.printfulapp.app.viewmodel.BeersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        BeersViewModel(get())
    }
}