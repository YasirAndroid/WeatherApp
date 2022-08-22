package com.demo.weatherapp.retrofit

import com.demo.weatherapp.model.CurrentWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/data/2.5/weather?")
    fun getDailyWeather(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ) : Call<CurrentWeatherModel>
}