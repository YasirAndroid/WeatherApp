package com.demo.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.weatherapp.model.CurrentWeatherModel
import com.demo.weatherapp.repo.mainRepo

class MainViewModel : ViewModel() {

    val data = MutableLiveData<CurrentWeatherModel>()

    val repo = mainRepo

    fun getWeatherData(){
        repo.getDailyData().observeForever {
            data.value = it
        }
    }
}