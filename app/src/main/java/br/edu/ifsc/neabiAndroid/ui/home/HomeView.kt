package br.edu.ifsc.neabiAndroid.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.edu.ifsc.neabiAndroid.domain.model.Address
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard
import kotlinx.coroutines.launch


@Composable
fun HomeView(viewModel: HomeViewModel) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sistema Educacional") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },

                )
        },
        scaffoldState = scaffoldState,
        drawerContent = {}
    ) {
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
            var allCampus = viewModel.campus.observeAsState()
            for (item in allCampus.value ?: listOf()){
                CampusCard(campus = item)
            }
        }
    }
}
