package br.edu.ifsc.neabiAndroid.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val searchText by viewModel.filter.observeAsState("")
    val campusList by viewModel.campus.observeAsState(initial = listOf())
    val focusManager = LocalFocusManager.current
    var fabState by remember { mutableStateOf(false) }

    Column() {
        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            value = searchText,
            onValueChange = {
                viewModel.updateFilter(it)
            },
            shape = MaterialTheme.shapes.medium.copy(
                topStart = CornerSize(0.dp),
                topEnd = CornerSize(0.dp)
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Row(){
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    Text("Buscar")
                }
            },
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
        Box(modifier = Modifier.fillMaxSize()) {
            if (!fabState) {
                LazyColumn() {
                    items(campusList) {
                        CampusCard(navController = navController, campus = it)
                    }
                    item {
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
            } else {
                val mapCenter = LatLng(-26.1833444,-50.3670326)
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(mapCenter, 7f)
                }
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    campusList.forEach { campus ->
                        Marker(
                            position = LatLng(campus.address.latitude.toDouble(), campus.address.longitude.toDouble()),
                            title = campus.name,
                            snippet = campus.name,
                            onInfoWindowClick = {
                                navController.navigate("campus/${campus.pk}")
                            }
                        )
                    }

                }
            }

            FloatingActionButton(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .align(alignment = Alignment.BottomStart)
                    .scale(1.05f),
                onClick = { fabState = !fabState },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    tint = Color.White,
                    contentDescription = "Abrir Mapa"
                )
            }
        }
    }
}
