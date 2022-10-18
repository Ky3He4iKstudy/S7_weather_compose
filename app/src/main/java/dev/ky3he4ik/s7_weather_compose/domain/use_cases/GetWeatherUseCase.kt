package dev.ky3he4ik.s7_weather_compose.domain.use_cases

import dev.ky3he4ik.s7_weather_compose.domain.model.WeatherData
import dev.ky3he4ik.s7_weather_compose.domain.repository.LocalWeatherRepository
import dev.ky3he4ik.s7_weather_compose.domain.repository.OpenWeatherRepository
import java.time.LocalDateTime

class GetWeatherUseCase (
    private val localRepository: LocalWeatherRepository,
    private val remoteRepository: OpenWeatherRepository,
) {
    suspend operator fun invoke(): List<WeatherData> {
        val localData = localRepository.getWeather()
        val curr_date = LocalDateTime.now()
        if (curr_date.plusDays(5) < localData.last().date)
            return localData
        val remoteData = remoteRepository.getWeather()
        if (remoteData.isEmpty())
            return localData
        localRepository.setWeather(remoteData)
        return remoteData
    }
}