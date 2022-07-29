package br.edu.ifsc.neabiAndroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.edu.ifsc.neabiAndroid.ui.theme.NeabiAndroidTheme
//import br.edu.ifsc.neabiAndroid.presentation.CampusViewModel
//import br.edu.ifsc.neabiAndroid.presentation.CampusViewModelFactory
//import br.edu.ifsc.neabiAndroid.presentation.showCampus
import br.edu.ifsc.neabiAndroid.ui.home.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NeabiAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NeabicanApp()
                }
            }
        }
    }
}

@Composable
fun NeabicanApp() {
    HomeView()
}