package br.edu.ifsc.neabiAndroid.ui.home

import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.data.local.entities.HomeEntity
import br.edu.ifsc.neabiAndroid.data.local.entities.toDomain
import br.edu.ifsc.neabiAndroid.domain.model.Address
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.model.Institution
import br.edu.ifsc.neabiAndroid.domain.repository.HomeRepository
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository
import br.edu.ifsc.neabiAndroid.ui.loading.LoadViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class HomeViewModel(private val rep: HomeRepository): ViewModel() {

    init {
        viewModelScope.launch {
            _campus = rep.getCampus()
        }
    }

    private var _campus: LiveData<List<Campus>> = MutableLiveData()
    val campus: LiveData<List<Campus>>
        get() = _campus
}

class HomeVMFactory(private val repository: HomeRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}