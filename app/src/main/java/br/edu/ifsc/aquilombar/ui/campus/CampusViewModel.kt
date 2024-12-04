package br.edu.ifsc.aquilombar.ui.campus

import androidx.lifecycle.*
import br.edu.ifsc.aquilombar.domain.model.Campus
import br.edu.ifsc.aquilombar.domain.repository.CampusRepository
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CampusViewModel(private val rep: CampusRepository): ViewModel() {

    private var _campus: LiveData<Campus> = MutableLiveData()
    val campus: LiveData<Campus>
        get() = _campus

    private val _loc: LiveData<LatLng> = MutableLiveData()
    val loc = _loc.asFlow()

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
