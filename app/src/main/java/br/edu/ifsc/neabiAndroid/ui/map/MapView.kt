package br.edu.ifsc.neabiAndroid.ui.map

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun MapView(
    navController: NavController
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
    ) {
        Row() {
            Text("MapView")
        }
    }
}
