package dev.ky3he4ik.s7_weather_compose.data.repository

import dev.ky3he4ik.s7_weather_compose.data.data_source.WeatherDataSource
import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import dev.ky3he4ik.s7_weather_compose.domain.repository.OpenWeatherRepository

class OpenWeatherRepositoryImpl(private val datasource: WeatherDataSource): OpenWeatherRepository {
    override suspend fun getWeather(): List<WeatherData> {
        return datasource.getWeather()
    }
}