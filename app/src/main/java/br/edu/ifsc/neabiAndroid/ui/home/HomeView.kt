package br.edu.ifsc.neabiAndroid.ui.home

import android.Manifest
import android.annotation.SuppressLint
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.ui.home.components.CampusCard
import br.edu.ifsc.neabiAndroid.ui.sharedcomp.SearchField
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeView(
    viewModel: HomeViewModel,
    navController: NavController,
) {
    val searchText by viewModel.filter.observeAsState("")
    val campusList by viewModel.campus.observeAsState(initial = listOf())
    val focusManager = LocalFocusManager.current
    var fabState by remember { mutableStateOf(false) }

    val permissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
        val eventObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    permissionState.launchPermissionRequest()
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(eventObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(eventObserver)
        }
    })

    Column {
        Spacer(modifier = Modifier.height(0.dp))

        SearchField(
            search = searchText,
            onValueChange = { viewModel.updateFilter(it) },
            focusManager = focusManager,
            onClearButtonClicked = {viewModel.updateFilter("")}
        )

        Box(modifier = Modifier.fillMaxSize()) {
            if (!fabState) {
                LazyColumn {
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
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(
                        isMyLocationEnabled = true
                    ),
                    uiSettings = MapUiSettings(
                        compassEnabled = true,
                        myLocationButtonEnabled = true
                    )
                ) {
                    campusList.forEach { campus ->
                        Marker(
                            position = LatLng(campus.address.latitude.toDouble(), campus.address.longitude.toDouble()),
                            title = campus.institution.initials,
                            snippet = campus.name,
                            onInfoWindowClick = {
                                navController.navigate("campus/${campus.pk}")
                            }
                        )
                    }

                }
            }

            if (permissionState.hasPermission)
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