package com.demo.weatherapp.repo

import androidx.lifecycle.MutableLiveData
import com.demo.weatherapp.model.CurrentWeatherModel
import com.demo.weatherapp.retrofit.APIClient
import com.demo.weatherapp.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object mainRepo {

     fun getDailyData(): MutableLiveData<CurrentWeatherModel> {
        val data=MutableLiveData<CurrentWeatherModel>()

        val service = APIClient.getCurrentData()!!.create(Api::class.java)

        val call = service.getDailyWeather("Mumbai", "ae1c4977a943a50eaa7da25e6258d8b2", "metric")
        call.enqueue(object : Callback<CurrentWeatherModel> {

            override fun onResponse(call: Call<CurrentWeatherModel>, response: Response<CurrentWeatherModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<CurrentWeatherModel>, t: Throwable) {

            }
        })
        return data
    }
}