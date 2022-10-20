package br.edu.ifsc.neabiAndroid.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard

@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val searchText by viewModel.filter.observeAsState("")
    val campusList by viewModel.campus.observeAsState(initial = listOf())

    Column() {
        TextField(
            value = searchText,
            onValueChange = {
                viewModel.updateFilter(it)
            },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar") },
        )
        LazyColumn() {
            item {
                Spacer(modifier = Modifier.size(16.dp))
            }
            items(campusList) {
                CampusCard(navController = navController, campus = it)
            }

        }
    }
}
