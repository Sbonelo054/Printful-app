package com.printfulapp.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.printfulapp.app.model.Beers
import com.printfulapp.app.model.BeersItem
import com.printfulapp.app.repository.BeersRepository
import kotlinx.coroutines.launch

class BeersViewModel(val repo : BeersRepository) : ViewModel() {

    fun getBeers() : MutableLiveData<List<BeersItem>>?{
        val data : MutableLiveData<List<BeersItem>> = MutableLiveData()
        viewModelScope.launch {
            val results = repo.getBeers()
            data.value = results
        }
        return data
    }
}