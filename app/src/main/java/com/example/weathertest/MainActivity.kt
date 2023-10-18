package com.example.weathertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathertest.ui.theme.WeatherTestTheme
import com.example.weathertest.viewmodel.WeatherViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.example.weathertest.repository.WeatherRepository
import com.example.weathertest.viewmodel.WeatherViewModelFactory


class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by lazy {
        ViewModelProvider(this, WeatherViewModelFactory(WeatherRepository())).get(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    WeatherApp(viewModel)
                }
            }
        }
    }
}


@Composable
fun WeatherApp(viewModel: WeatherViewModel) {

    val weather = viewModel.weather.observeAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (weather != null) {
            Text(text = "Temperature: ${weather.temp}°")
            Text(text = "Feels Like: ${weather.feelsLike}°")
            // ... 其他天气相关的组件
        } else {
            Text(text = "Loading...")
        }
    }
}

