package com.example.cheers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cheers.network.BeerServiceApi
import com.example.cheers.network.Brewery
import kotlinx.coroutines.launch
import java.lang.Exception

class CheersViewModel: ViewModel() {
    private var _breweries = MutableLiveData<List<Brewery>>()
    private var _apiStatus = MutableLiveData<String>()

    public val breweries: LiveData<List<Brewery>> = _breweries
    public val apiStatus: LiveData<String> = _apiStatus
    public val adapter = BreweryAdapter()

    init {
        getBreweriesByCity("philadelphia")
    }

    private fun getBreweriesByCity(city: String) {
        viewModelScope.launch {
            try {
                _apiStatus.value = "SUCCESS"
                _breweries.value = BeerServiceApi.service.getBreweries(city)
                adapter.submitList(breweries.value)
            } catch (e: Exception) {
                _apiStatus.value = "FAILURE"
            }
        }
    }
}