package dev.ky3he4ik.s7_weather_compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.ky3he4ik.s7_weather_compose.data.repository.LocalWeatherApiImpl
import dev.ky3he4ik.s7_weather_compose.data.repository.LocalWeatherRepositoryImpl
import dev.ky3he4ik.s7_weather_compose.data.repository.OpenWeatherApiImpl
import dev.ky3he4ik.s7_weather_compose.data.repository.OpenWeatherRepositoryImpl
import dev.ky3he4ik.s7_weather_compose.domain.use_cases.GetWeatherUseCase
import dev.ky3he4ik.s7_weather_compose.presentation.get_weather.GetWeatherView
import dev.ky3he4ik.s7_weather_compose.presentation.get_weather.GetWeatherViewModel
import dev.ky3he4ik.s7_weather_compose.presentation.theme.S7_weather_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = GetWeatherViewModel(
            getWeatherUseCase = GetWeatherUseCase(
                localRepository = LocalWeatherRepositoryImpl(
                    datasource = LocalWeatherApiImpl()
                ),
                remoteRepository = OpenWeatherRepositoryImpl(
                    datasource = OpenWeatherApiImpl()
                ),
            )
        )
        setContent {
            S7_weather_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GetWeatherView(vm)
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    S7_weather_composeTheme {
        Greeting("Android")
    }
}