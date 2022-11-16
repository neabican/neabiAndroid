package br.edu.ifsc.neabiAndroid.ui.campus

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.edu.ifsc.neabiAndroid.data.remote.BASE_URL
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.R
import br.edu.ifsc.neabiAndroid.ui.components.AddressInfo
import br.edu.ifsc.neabiAndroid.ui.components.BoxInfo
import br.edu.ifsc.neabiAndroid.ui.components.CardItem
import br.edu.ifsc.neabiAndroid.ui.components.ExpandableCard
import br.edu.ifsc.neabiAndroid.ui.theme.PrimaryColor
import br.edu.ifsc.neabiAndroid.util.EmptyClass
import br.edu.ifsc.neabiAndroid.util.sizeExtraLarge
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium
import coil.compose.SubcomposeAsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CampusView(
    navController: NavController,
    campusViewModel: CampusViewModel
) {
    val campus = campusViewModel.campus.observeAsState(EmptyClass.emptyCampus)
    val permissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(sizeExtraLarge)
    ) {
        if(campus.value.image.isBlank())
            Image(painter = painterResource(id = R.drawable.template),
                contentDescription = "Imagem genérica do Campus")
        else
        SubcomposeAsyncImage(
            model = BASE_URL+ campus.value.image,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "image",
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceEvenly
        ) {
            BoxInfo("Cursos", campus.value.courses.size)
            BoxInfo("Programas", campus.value.program.size)
            BoxInfo("Projetos", campus.value.project.size)
            BoxInfo("Auxílio Estudantil", campus.value.studentAssistence.size)
        }

        ExpandableCard("Endereço") {
            AddressInfo(campus.value.address)
        }

        if(campus.value.courses.isNotEmpty())
            ExpandableCard("Cursos") {
                Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                    for (course in campus.value.courses)
                        CardItem(name = course.course.name){
                            navController.navigate("course/${course.pk}")
                        }
                }
            }

        if(campus.value.program.isNotEmpty())
            ExpandableCard("Programas") {
                Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                    for(program in campus.value.program)
                        CardItem(name = program.name){
                            navController.navigate("home")
                        }
                }
            }

        if(campus.value.project.isNotEmpty())
            ExpandableCard("Projetos") {
                Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                    for(proj in campus.value.project)
                        CardItem(name = proj.name){
                            navController.navigate("home")
                        }
                }
            }

        if(campus.value.studentAssistence.isNotEmpty())
            ExpandableCard("Assistência Estudantil") {
                Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                    for(action in campus.value.studentAssistence)
                        CardItem(name = action.name){
                            navController.navigate("home")
                        }
                }
            }

        Row(
            modifier = Modifier
                .padding(start = sizeExtraLarge, end = sizeExtraLarge)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(sizeLarge))
                    .border(1.dp, PrimaryColor, RoundedCornerShape(sizeLarge))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if(permissionState.hasPermission){
                    val mapCenter by campusViewModel.loc.observeAsState(initial = LatLng(-26.1833444,-50.3670326))
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(mapCenter, 6.0f)
                    }

                    LaunchedEffect(key1 = mapCenter){
                        cameraPositionState.position = CameraPosition.fromLatLngZoom(LatLng(mapCenter.latitude,mapCenter.longitude),6.0f)
                    }

                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState,
                        properties = MapProperties(
                            isMyLocationEnabled = true
                        )
                    ){
                        Marker(
                            position = LatLng(
                                campus.value.address.latitude.toDouble(),
                                campus.value.address.longitude.toDouble(),
                            )
                        )
                    }
                }
                else Text(text = "Sem permissão de GPS")
            }
        }

        val uriHandler = LocalUriHandler.current
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = sizeExtraLarge, end = sizeExtraLarge),
            shape = RoundedCornerShape(sizeMedium),
            onClick = {
                uriHandler.openUri(campus.value.link)
            }
        ) {
            Text("Visitar site da instituição")
        }

        Spacer(modifier = Modifier.size(sizeMedium))
    }
}
