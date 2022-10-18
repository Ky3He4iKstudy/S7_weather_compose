package dev.ky3he4ik.s7_weather_compose.data.repository

import dev.ky3he4ik.s7_weather_compose.data.data_source.WeatherDataSource
import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import dev.ky3he4ik.s7_weather_compose.domain.repository.LocalWeatherRepository

class LocalWeatherRepositoryImpl(private val datasource: WeatherDataSource) :
    LocalWeatherRepository {
    override suspend fun getWeather(): List<WeatherData> {
        return datasource.getWeather()
    }

    override suspend fun setWeather(data: List<WeatherData>) {
        TODO("DO")
    }
}
