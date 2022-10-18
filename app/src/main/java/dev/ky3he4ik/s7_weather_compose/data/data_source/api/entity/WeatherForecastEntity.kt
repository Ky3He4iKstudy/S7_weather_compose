package dev.ky3he4ik.s7_weather_compose.data.data_source.api.entity

import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import java.util.*

data class WeatherForecastEntity(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherInfo>,
    val city: City

    /*
     "cod": "200",
  "message": 0,
  "cnt": 40,
  "list": [

  ],
  "city": {

  }
    */
) {
    data class WeatherInfo(
        val dt: Long,
        val main: WeatherInfoEntitity,
        val weather: List<WeatherText>,
        val clouds: WeatherClouds,
        val wind: WeatherWind,
        val visibility: Int,
        val pop: Int,
        val sys: Sys,
        val dt_txt: String,
    )

    data class Sys(
        val pod: String
    )

    data class City(
        val id: Int,
        val name: String,
        val coord: Coord,
        val country: String,
        val population: Int,
        val timezone: Int,
        val sunrise: Long,
        val sunset: Long,
    )
    /*
    "id": 2643743,
    "name": "London",
    "coord": {
      "lat": 51.5085,
      "lon": -0.1257
    },
    "country": "GB",
    "population": 1000000,
    "timezone": 0,
    "sunrise": 1647324902,
    "sunset": 1647367441
     */


    fun toWeatherData(): WeatherData {
        return WeatherData(id, temperature, feel_temp, wind_speed, wind_direction, weather_type, date)
    }
}
