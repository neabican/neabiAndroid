package br.edu.ifsc.neabiAndroid.ui.campus

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsc.neabiAndroid.data.local.entities.AllCampusInfo
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.repository.CampusRepository
import br.edu.ifsc.neabiAndroid.domain.repository.HomeRepository
import br.edu.ifsc.neabiAndroid.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class CampusViewModel(private val rep: CampusRepository): ViewModel() {

    private val _campus = rep.getCampus(1)

    val campus: LiveData<Campus>
        get() = _campus
}



class CampusVMFactory(private val repository: CampusRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CampusViewModel::class.java))
            return CampusViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
