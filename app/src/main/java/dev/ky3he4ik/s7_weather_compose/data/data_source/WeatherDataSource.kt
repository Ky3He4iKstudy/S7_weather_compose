package dev.ky3he4ik.s7_weather_compose.data.data_source

import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import org.joda.time.DateTime

interface WeatherDataSource {
    suspend fun getWeather(): List<WeatherData>
}
