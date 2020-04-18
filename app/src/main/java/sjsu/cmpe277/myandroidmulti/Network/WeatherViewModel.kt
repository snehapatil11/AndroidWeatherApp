package sjsu.cmpe277.myandroidmulti.Network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

private const val WeatherAPPID = "2b492c001d57cd5499947bd3d3f9c47b"

class WeatherViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // TODO: Implement the ViewModel
    // The internal MutableLiveData String that stores the most recent response
    val _response = MutableLiveData<String>();
    val _temp = MutableLiveData<String>();
    val _weather = MutableLiveData<String>();
    val _city = MutableLiveData<String>();
    val mintemp = MutableLiveData<String>();
    val maxtemp = MutableLiveData<String>();
    val pressure = MutableLiveData<String>();
    val humidity = MutableLiveData<String>();
    val sunrise = MutableLiveData<String>();
    val sunset = MutableLiveData<String>();
    val minmaxTemp = MutableLiveData<String>();
    val feelslike = MutableLiveData<String>();
    val wind = MutableLiveData<String>();
    val icon = MutableLiveData<String>();


    /**
     * Call getWeatherProperties() on init so we can display status immediately.
     */
    init {
        getWeatherProperties()
    }

    private fun getWeatherProperties() {
        //_response.value = "Set the Weather API Response here!"
        //WeatherApi.retrofitService.getProperties()
        WeatherApi.retrofitService.getProperties("San Jose", WeatherAPPID).enqueue(
            object: Callback<WeatherProperty> {
                override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    _response.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<WeatherProperty>, response: Response<WeatherProperty>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    val dec = DecimalFormat("#,###.00");
                    _response.value = "${response.body()?.weather?.get(0)?.description}";
                    icon.value = "${response.body()?.weather?.get(0)?.icon}";
                    _city.value = "${response.body()?.name}"



                    val feelvalue = response.body()?.mainpart?.feels_like;
                    val feelvalueF = (9.0 / 5 * (feelvalue?.minus(273)!!) + 32);
                    val feelvalueD = dec.format(feelvalueF);
                    feelslike.value = "Feels Like $feelvalueD °F";

                    wind.value = "Wind Speed \n ${response.body()?.wind?.speed} m/s";
                    pressure.value = "Pressure ${response.body()?.mainpart?.pressure} hPa";
                    humidity.value = "Humidity \n ${response.body()?.mainpart?.humidity} %";




                    //_response.value = "Success: ${response.body()?.name} city is retrieved; Temperature: ${response.body()?.mainpart?.temp}; Humidity: ${response.body()?.mainpart?.humidity}"
                }

            }
        )
    }
}
