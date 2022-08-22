package com.demo.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.demo.weatherapp.databinding.ActivityMainBinding
import com.demo.weatherapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.data.observe(this){
            binding.tvTemp.text = it.main.temp.toInt().toString().plus("\u2103")
            binding.tvMax.text = it.main.tempMax.toInt().toString().plus("\u2103")
            binding.tvMin.text = it.main.tempMin.toInt().toString().plus("\u2103")
            binding.tvWind.text = it.wind.speed.toString()
            binding.tvWeather.text = it.weather[0].main

        }
        viewModel.getWeatherData()
    }
}