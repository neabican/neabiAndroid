package br.edu.ifsc.neabiAndroid.ui.home

import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.repository.HomeRepository
import br.edu.ifsc.neabiAndroid.util.Resource
import kotlinx.coroutines.flow.*
import java.lang.IllegalArgumentException
import kotlinx.coroutines.launch


class HomeViewModel(private val rep: HomeRepository): ViewModel() {

    private val _campus: Flow<Resource<List<Campus>>> = rep.getCampus()
    val campus = _campus

    var campusList = emptyList<Campus>()

    init {
        viewModelScope.launch {
            campus.collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        campusList = resource.data!!
                    }
                }

            }
        }
    }

    fun getCampus(searchOption: String?): List<Campus> {
        if (searchOption != null) {
            return campusList.filter { it.name.contains(searchOption, ignoreCase = true) }
        }
        return campusList
    }
}

class HomeVMFactory(private val repository: HomeRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}