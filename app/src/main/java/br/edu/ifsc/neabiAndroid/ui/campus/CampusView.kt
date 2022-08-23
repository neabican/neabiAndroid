package br.edu.ifsc.neabiAndroid.ui.campus

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.ifsc.neabiAndroid.ui.campus.components.BoxInfo
import br.edu.ifsc.neabiAndroid.ui.campus.components.ExpandableCard
import br.edu.ifsc.neabiAndroid.ui.theme.PrimaryColor
import coil.compose.SubcomposeAsyncImage


@Composable
fun CampusView(
    viewModel: CampusViewModel
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SubcomposeAsyncImage(
            model = viewModel.getImage(),
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "image",
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement =  Arrangement.SpaceEvenly
        ) {
            BoxInfo("Cursos", 1)
            BoxInfo("Programas", 2)
            BoxInfo("Projetos", 0)
            BoxInfo("Ações Afirmativas", 1)
        }

        ExpandableCard("Endereço") {
            Text("Rua dos Bobos, 0")
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .background(color = PrimaryColor, shape = RoundedCornerShape(10.dp)),
            shape = RoundedCornerShape(10.dp),
            onClick = { /*TODO*/ }
        ) {
            Text("Visitar site da instituição")
        }

        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .border(1.dp, PrimaryColor, RoundedCornerShape(16.dp))
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Map")
                /*TODO*/
            }
        }

        Spacer(modifier = Modifier.size(16.dp))
    }
}
