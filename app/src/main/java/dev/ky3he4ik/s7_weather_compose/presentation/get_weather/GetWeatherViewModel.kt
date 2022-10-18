package dev.ky3he4ik.s7_weather_compose.presentation.get_weather

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import dev.ky3he4ik.s7_weather_compose.domain.use_cases.GetWeatherUseCase
import kotlinx.coroutines.launch

class GetWeatherViewModel constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {
    private val _todos = mutableStateListOf<WeatherData>()

    val todos: List<WeatherData>
        get() = _todos


    suspend fun getWeather() {
        viewModelScope.launch {
            _todos.addAll(getWeatherUseCase())
        }
    }
}
