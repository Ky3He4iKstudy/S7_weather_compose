package dev.ky3he4ik.s7_weather_compose.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class WeatherData(
    val id: UUID,
    val temperature: Int,
    val feel_temp: Int,
    val wind_speed: Int,
    val wind_direction: String,
    val weather_type: Int,
    val date: LocalDateTime,

    val lat: Float,
    val lon: Float,
    val lang: String,
)
