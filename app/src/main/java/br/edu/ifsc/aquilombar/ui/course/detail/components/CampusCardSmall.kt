package br.edu.ifsc.aquilombar.ui.course.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.ifsc.aquilombar.R
import br.edu.ifsc.aquilombar.data.remote.BaseURL.BASE_URL
import br.edu.ifsc.aquilombar.domain.model.Campus
import br.edu.ifsc.aquilombar.ui.components.Carousel
import br.edu.ifsc.aquilombar.util.sizeLarge
import br.edu.ifsc.aquilombar.util.sizeMedium
import br.edu.ifsc.aquilombar.util.sizeSmall

@Composable
fun CampusCardSmall(navController: NavController, campus: Campus) {
    Card(
        modifier = Modifier
            .padding(sizeMedium)
            .fillMaxWidth()
            .clickable {
                navController.navigate("campus/${campus.pk}")
            },
        elevation = sizeSmall,
        shape = RoundedCornerShape(sizeLarge)
    ) {
        Column {
            Spacer(modifier = Modifier.height(sizeSmall))
            Text(
                campus.name.removePrefix("Campus ").removePrefix("Câmpus "),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = sizeLarge)
            )
            Spacer(modifier = Modifier.height(sizeSmall))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (campus.image.isEmpty()) {
                    Image(
                        painter = painterResource(id = R.drawable.default_campus_image),
                        contentDescription = "Imagem genérica",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(128.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                } else {
                    val urlList = campus.image.map { i ->
                        BASE_URL + i.photo
                    }

                    Carousel(images = urlList)
                }
                Button(
                    onClick = {
                        navController.navigate("campus/${campus.pk}")
                    },
                    modifier = Modifier.fillMaxSize(),
                    shape = MaterialTheme.shapes.medium.copy(
                        topEnd = CornerSize(0.dp),
                        topStart = CornerSize(0.dp)
                    )
                ) {
                    Text(
                        "Acessar Campus",
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}