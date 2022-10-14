package br.edu.ifsc.neabiAndroid.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.domain.model.Campus

import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard


@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    var searchText by remember { mutableStateOf("") }

    val campusList = mutableStateListOf<Campus>()
    campusList.addAll(viewModel.getCampus(null))

    LazyColumn() {
        item {
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    campusList.clear()
                    campusList.addAll(viewModel.getCampus(it))
                },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Buscar") },
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
        items(campusList) {
            CampusCard(navController = navController, campus = it)
        }

    }
}
