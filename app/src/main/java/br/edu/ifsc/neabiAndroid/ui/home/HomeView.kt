package br.edu.ifsc.neabiAndroid.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
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
    val focusManager = LocalFocusManager.current

    Column() {
        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            value = searchText,
            onValueChange = {
                viewModel.updateFilter(it)
            },
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar") },
            trailingIcon = {
                if(searchText!=""){
                    IconButton(onClick = { viewModel.updateFilter("") }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Limpar Pesquisa")
                    }
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
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
