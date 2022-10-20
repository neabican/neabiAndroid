package br.edu.ifsc.neabiAndroid.ui.campus

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import br.edu.ifsc.neabiAndroid.data.remote.BASE_URL
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.ui.campus.components.AddressInfo
import br.edu.ifsc.neabiAndroid.ui.campus.components.BoxInfo
import br.edu.ifsc.neabiAndroid.ui.campus.components.CardItem
import br.edu.ifsc.neabiAndroid.ui.campus.components.ExpandableCard
import br.edu.ifsc.neabiAndroid.ui.theme.PrimaryColor
import br.edu.ifsc.neabiAndroid.util.sizeExtraLarge
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium
import coil.compose.SubcomposeAsyncImage


@Composable
fun CampusView(
    navController: NavController,
    campusViewModel: CampusViewModel
) {
    var campus = campusViewModel.campus.observeAsState()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(sizeExtraLarge)
    ) {
        SubcomposeAsyncImage(
            model = BASE_URL+campus.value?.image,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "image",
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceEvenly
        ) {
            BoxInfo("Cursos", campus.value?.courses?.size ?: 0)
            BoxInfo("Programas", campus.value?.program?.size ?: 0)
            BoxInfo("Projetos", campus.value?.project?.size ?: 0)
            BoxInfo("Ações Afirmativas", campus.value?.affirmativeAction?.size ?: 0)
        }


        ExpandableCard("Endereço") {
            AddressInfo(campus.value?.address)
        }

        ExpandableCard("Cursos") {
            Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                for (course in campus.value?.courses ?: listOf())
                    CardItem(name = course.course.name){
                        navController.navigate("course/${course.pk}")
                    }
            }
        }

        ExpandableCard("Programas") {
            Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                for(program in campus.value?.program ?: listOf())
                    CardItem(name = program.name){
                        navController.navigate("home")
                    }
            }
        }

        ExpandableCard("Projetos") {
            Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                for(proj in campus.value?.project ?: listOf())
                    CardItem(name = proj.name){
                        navController.navigate("home")
                    }
            }
        }
        ExpandableCard("Ações Afirmativas") {
            Column(verticalArrangement = Arrangement.spacedBy(sizeMedium)) {
                for(action in campus.value?.affirmativeAction ?: listOf())
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
                    .border(1.dp, PrimaryColor, RoundedCornerShape(sizeLarge))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Map")
                /*TODO*/
            }
        }

        val uriHandler = LocalUriHandler.current
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = sizeExtraLarge, end = sizeExtraLarge),
            shape = RoundedCornerShape(sizeMedium),
            onClick = {
                uriHandler.openUri(campus.value?.link ?: "www.google.com")
            }
        ) {
            Text("Visitar site da instituição")
        }

        Spacer(modifier = Modifier.size(sizeMedium))
    }
}
