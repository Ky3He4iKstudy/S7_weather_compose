package dev.ky3he4ik.s7_weather_compose.data.repository

import dev.ky3he4ik.s7_weather_compose.data.data_source.WeatherDataSource
import dev.ky3he4ik.s7_weather_compose.data.data_source.api.entity.WeatherForecastEntity
import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import retrofit2.Retrofit
import retrofit2.http.GET

interface OpenWeatherApi {

    @GET("todos")
    suspend fun getWeather(): List<WeatherForecastEntity>

    companion object {
        var todoApi: OpenWeatherApi? = null
        fun getInstance(): OpenWeatherApi {
            if (todoApi == null) {
                todoApi = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(OpenWeatherApi::class.java)
            }
            return todoApi!!
        }
    }
}

class OpenWeatherApiImpl : WeatherDataSource {
    override suspend fun getWeather(): List<WeatherData> {
        return OpenWeatherApi.getInstance().getWeather().map { it.toWeatherData() }
    }
}
