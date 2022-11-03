package br.edu.ifsc.neabiAndroid.ui.campus

import android.util.Log
import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.repository.CampusRepository
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CampusViewModel(private val rep: CampusRepository): ViewModel() {

    private var _campus: LiveData<Campus> = MutableLiveData()
    val campus: LiveData<Campus>
        get() = _campus

    val loc: LiveData<LatLng>
        get() {
            return MutableLiveData(
                LatLng(
                _campus.value?.address?.latitude?.toDouble()?:0.0,
                _campus.value?.address?.longitude?.toDouble()?:0.0
                )
            )
        }

    fun setCampus(int: Int){
        viewModelScope.launch {
             _campus = rep.getCampus(int)
        }
    }

}



class CampusVMFactory(private val repository: CampusRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CampusViewModel::class.java))
            return CampusViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
