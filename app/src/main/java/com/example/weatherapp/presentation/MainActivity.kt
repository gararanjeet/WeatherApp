package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.remote.RetrofitProvider
import com.example.weatherapp.data.repository.ForecastRepository
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Button()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Button() {
    Button(onClick = {
        CoroutineScope(Dispatchers.IO).launch{
            RetrofitProvider.init()
            ForecastRepository(RetrofitProvider.getRetrofitService()).getForecastWeather()
        }
    }) {
        Text("Click")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        Greeting("Ranjeet")
    }
}
@Preview
@Composable
fun Button1() {
    Button(onClick = {
        CoroutineScope(Dispatchers.IO).launch{
            RetrofitProvider.init()
            ForecastRepository(RetrofitProvider.getRetrofitService()).getForecastWeather()
        }
    }) {
        Text("Click")
    }
}