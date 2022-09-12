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
import br.edu.ifsc.neabiAndroid.domain.model.Address
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard


@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf("") }
    var allCampus = viewModel.campus.observeAsState()

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
        for (item in allCampus.value?: listOf()) {
            CampusCard(navController = navController, campus = item)
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = {
                navController.navigate("course/1")
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "Clique para acessar um curso de teste",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}
