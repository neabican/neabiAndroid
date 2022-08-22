package br.edu.ifsc.neabiAndroid

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.edu.ifsc.neabiAndroid.data.local.NeabicanDatabase
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.domain.repository.InitializationRepository
import br.edu.ifsc.neabiAndroid.ui.theme.NeabiAndroidTheme
//import br.edu.ifsc.neabiAndroid.presentation.CampusViewModel
//import br.edu.ifsc.neabiAndroid.presentation.CampusViewModelFactory
//import br.edu.ifsc.neabiAndroid.presentation.showCampus
import br.edu.ifsc.neabiAndroid.ui.home.HomeView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val initialization = InitializationRepository(NeabicanDatabase.getInstance(this))
        setContent {
            NeabiAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NeabicanApp(initialization)
                }
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NeabicanApp(initial: InitializationRepository) {
    GlobalScope.launch {
        initial.getInstances()
    }
    HomeView()
}