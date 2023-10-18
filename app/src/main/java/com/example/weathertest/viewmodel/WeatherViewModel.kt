package com.example.weathertest.viewmodel

import androidx.lifecycle.*
import com.example.weathertest.model.WeatherDetails
import com.example.weathertest.repository.WeatherRepository
import kotlinx.coroutines.launch


class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val _weather = MutableLiveData<WeatherDetails>()
    val weather: LiveData<WeatherDetails> get() = _weather

    init {
        fetchWeather("101010100", "96cd5063b4d04e1bbcbd7fe6ab4d0aab")
    }

    private fun fetchWeather(location: String, key: String) {
        viewModelScope.launch {
            try {
                val result = repository.getWeather(location, key)
                _weather.value = result
            } catch (exception: Exception) {
                println(exception)
            }
        }
    }
}


class WeatherViewModelFactory(private val repository: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
