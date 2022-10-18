package dev.ky3he4ik.s7_weather_compose.data.data_source.api.entity

data class CurrentWeatherEntity(
    val coord: Coord,
    val weather: List<WeatherText>,
    val base: String,
    val main: WeatherInfoEntitity,
    val visibility: Int,
    val wind: WeatherWind,
    val clouds: WeatherClouds,
    val rain: PrecipSoon,
    val snow: PrecipSoon,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
) {
    data class PrecipSoon(
        val `1h`: Float,
        val `3h`: Float
    )

    data class Sys(
        val type: Int,
        val id: Int,
        val country: String,
        val sunrise: Long,
        val sunset: Long
    )
}