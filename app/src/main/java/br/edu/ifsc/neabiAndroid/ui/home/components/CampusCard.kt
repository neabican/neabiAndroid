package br.edu.ifsc.neabiAndroid.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.edu.ifsc.neabiAndroid.domain.model.Campus
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium
import br.edu.ifsc.neabiAndroid.util.sizeSmall
import coil.compose.SubcomposeAsyncImage

@Composable
fun CampusCard(campus: Campus) {
    Card(
        modifier = Modifier
            .padding(sizeMedium)
            .fillMaxWidth(),
        elevation = sizeSmall,
        shape = RoundedCornerShape(5)
    ) {
        Column {
            Spacer(modifier = Modifier.height(sizeSmall))
            Text(
                campus.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = sizeLarge)
            )
            Text(
                campus.institution.name,
                modifier = Modifier.padding(start = sizeLarge)
            )
            Spacer(modifier = Modifier.height(sizeSmall))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubcomposeAsyncImage(
                    model = "https://via.placeholder.com/1100x500",
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = "image",
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        "Clique para mais informações sobre a instituição",
                        fontSize = 13.sp
                    )
                }
            }
        }

    }
}