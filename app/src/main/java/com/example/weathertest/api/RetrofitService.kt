package com.example.weathertest.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://devapi.qweather.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val weatherApi: WeatherApi = retrofit.create(WeatherApi::class.java)
}