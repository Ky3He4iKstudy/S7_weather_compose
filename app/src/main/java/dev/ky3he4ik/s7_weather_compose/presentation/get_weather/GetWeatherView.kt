package dev.ky3he4ik.s7_weather_compose.presentation.get_weather

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import dev.ky3he4ik.s7_weather_compose.domain.use_cases.GetWeatherUseCase
import java.lang.reflect.Modifier

@Composable
fun GetWeatherView(vm: GetWeatherViewModel) {

    LaunchedEffect(Unit, block = {
        vm.getWeather()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Weather")
                }
            )
        },
        content = {
            TableInfo.Column(modifier = Modifier.padding(16.dp)) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    items(vm.todos) { todo ->
                        Row(modifier = Modifier.padding(16.dp)) {
                            Checkbox(checked = todo.isCompleted, onCheckedChange = null)
                            Spacer(Modifier.width(5.dp))
                            Text(todo.task)
                        }
                        Divider()
                    }
                }
            }
        }
    )
}
