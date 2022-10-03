package br.edu.ifsc.neabiAndroid.ui.campus

import android.util.Log
import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.repository.CampusRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CampusViewModel(private val rep: CampusRepository): ViewModel() {

    private var _campus: LiveData<Campus> = MutableLiveData()
    val campus: LiveData<Campus>
        get() = _campus

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
