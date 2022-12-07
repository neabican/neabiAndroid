package br.edu.ifsc.neabiAndroid.ui.splash

import android.util.Log
import androidx.lifecycle.*
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class SplashViewModel(private val repository: InitializationRepository): ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading

    init {
        viewModelScope.launch {
            val localVersion = repository.getLocalVersion()
            val remoteVersion = repository.getApiVersion()
            Log.e("e", "local: $localVersion remote: $remoteVersion")
            if(localVersion==remoteVersion){
                _isLoading.value=false
                return@launch
            }

            val update = refreshDataBaseFromAPI()
            joinAll(update)
            _isLoading.value=false
        }
    }

    private fun refreshDataBaseFromAPI(): Job{
        return viewModelScope.launch{
            try {
               repository.refreshDatabase()
            }catch (e: Exception){
                Log.e("api", "Error in DB refresh: ${e.message}")
            }
        }
    }
}

class SplashVMFactory(private val repository: InitializationRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SplashViewModel::class.java))
            return SplashViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}