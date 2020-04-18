package sjsu.cmpe277.myandroidmulti.Title

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel: ViewModel() {

    var yourname = MutableLiveData<String>()
    // The current risk score
    val riskscore = MutableLiveData<Int>()

    init {
        Log.i("TitleViewModel", "TitleViewModel created!")
        yourname.value = ""
        riskscore.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TitleViewModel","TitleViewModel destroyed!")
    }

    fun updateRiskscore() {
        riskscore.value = (riskscore.value)?.plus(1)
        Log.i("TitleViewModel",riskscore.value.toString())
    }
}