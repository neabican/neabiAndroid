package br.edu.ifsc.neabiAndroid.ui.loading

import android.util.Log
import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.model.DBVersion
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class LoadViewModel(private val repository: InitializationRepository): ViewModel() {
    var dbVersion: Int = 0
    private val _currentState = MutableLiveData<Boolean>()

    val currentState: LiveData<Boolean>
    get() = _currentState


    init {
        _currentState.value = false
    }

    fun syncData(){
        dbVersion = getDBVersion()
        if(dbVersion==-1){
            refreshDataBaseFromAPI()
        }
    }

    private fun getDBVersion(): Int{
        var version: Int = -1
        viewModelScope.launch {
            try {
                version = repository.getApiVersion().version
            }catch (e: Exception){
                Log.e("room", "Error in DB getApiVersion: ${e.message}")
            }
        }
        return version
    }

    private fun refreshDataBaseFromAPI(){
        viewModelScope.launch{
            try {
                repository.refreshDatabase()
                _currentState.value = true
            }catch (e: Exception){
                Log.e("api", "Error in DB refresh: ${e.message}")
            }
        }
    }
}

class LoadVMFactory(private val repository: InitializationRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoadViewModel::class.java))
            return LoadViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}