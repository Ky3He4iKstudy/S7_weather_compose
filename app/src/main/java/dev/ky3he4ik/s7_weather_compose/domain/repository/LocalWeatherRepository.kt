package dev.ky3he4ik.s7_weather_compose.domain.repository

import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData

interface LocalWeatherRepository {
    suspend fun getWeather(): List<WeatherData>
    suspend fun setWeather(data: List<WeatherData>): Unit
}