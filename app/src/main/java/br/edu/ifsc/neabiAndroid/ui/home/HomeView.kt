package br.edu.ifsc.neabiAndroid.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard
import br.edu.ifsc.neabiAndroid.util.Resource


@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf("") }
    var allCampus = viewModel.campus.collectAsState(initial = Resource.Loading(true))
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFFFFFFF)
            )
        )
        Spacer(modifier = Modifier.size(16.dp))

        when(allCampus.value){
            is Resource.Error -> {}
            is Resource.Loading -> CircularProgressIndicator()
            is Resource.Success -> {
                allCampus.value.data?.forEach{
                    CampusCard(navController = navController, campus = it)
                }
            }
        }
    }
}
