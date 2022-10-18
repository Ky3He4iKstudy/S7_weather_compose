package dev.ky3he4ik.s7_weather_compose.data.data_source.api.entity

data class WeatherInfoEntitity(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val temp_kf: Float = 0f,
)

data class WeatherText(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

data class WeatherClouds(
    val all: Int
)

data class WeatherWind(
    val speed: Float,
    val deg: Int,
    val gust: Float
)

data class Coord(
    val lat: Float,
    val lon: Float,
)