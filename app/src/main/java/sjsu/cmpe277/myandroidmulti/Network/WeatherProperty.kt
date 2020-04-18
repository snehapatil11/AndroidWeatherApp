package sjsu.cmpe277.myandroidmulti.Network

import androidx.activity.OnBackPressedCallback
import com.squareup.moshi.Json

data class WeatherProperty(
    val id: String,


    // used to map main from the JSON to mainpart in our class
    @Json(name = "main") val mainpart: MainWeatherPart,
    @Json(name = "wind") val wind: WindPart,
    @Json(name = "sys") val sys: SysPart,
    val name: String,
    val cod: Double,
    val weather: List<WeatherPart>
)

data class WeatherPart(
    val id: Double,
    val main: String,
    val description: String,
    val icon: String
)
data class MainWeatherPart(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val feels_like: Double,
    val pressure: Double,
    val humidity: Double
)
data class WindPart(
    val speed: Double
)
data class SysPart(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
