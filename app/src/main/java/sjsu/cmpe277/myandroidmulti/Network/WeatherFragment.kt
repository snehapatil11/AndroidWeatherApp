package sjsu.cmpe277.myandroidmulti.Network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.weather_fragment.*
import sjsu.cmpe277.myandroidmulti.R
import sjsu.cmpe277.myandroidmulti.databinding.WeatherFragmentBinding


//import sun.invoke.util.VerifyAccess.getPackageName


class WeatherFragment : Fragment() {

//    companion object {
//        fun newInstance() = WeatherFragment()
//    }

    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<WeatherFragmentBinding>(inflater, R.layout.weather_fragment,container,false)
        //viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        viewModel._response.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weathertextView.text = newresponse.toString() //display the raw json data
        })
        viewModel.icon.observe(viewLifecycleOwner, Observer { newresponse ->
            val icon = newresponse.toString();
            val uri ="@drawable/a$icon"; // where myresource (without the extension) is the file
            val imageResource =
                resources.getIdentifier(uri, null, context?.packageName)
            //weatherimage.setImageResource(R.drawable.a02d);
            weatherimage.setImageResource(imageResource);
        })
        viewModel._temp.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weatherTempView.text = newresponse.toString() //display the raw json data
        })
        viewModel._city.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.citytextView.text = newresponse.toString() //display the raw json data
        })
        viewModel.minmaxTemp.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.weatherMinMaxTempView.text = newresponse.toString() //display the raw json data
        })
        viewModel.feelslike.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.feelslikeView.text = newresponse.toString() //display the raw json data
        })
        viewModel.wind.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.windView.text = newresponse.toString() //display the raw json data
        })
        viewModel.pressure.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.pressureView.text = newresponse.toString() //display the raw json data
        })
        viewModel.humidity.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.humidityView.text = newresponse.toString() //display the raw json data
        })
        viewModel.sunrise.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.sunriseView.text = newresponse.toString() //display the raw json data
        })
        viewModel.sunset.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.sunsetView.text = newresponse.toString() //display the raw json data
        })

        return binding.root//inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
