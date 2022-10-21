package br.edu.ifsc.neabiAndroid.ui.navegation

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import br.edu.ifsc.neabiAndroid.R

object Items {

    val menuItems = listOf(
        MenuItem(
            id = "Home",
            title = "Home",
            contentDescription = "Botão Home",
            icon = Icons.Default.Home,
        ),
        MenuItem(
            id = "Campus",
            title = "Câmpus",
            contentDescription = "Botão Câmpus",
            icon = Icons.Default.Place
        ),
        MenuItem(
            id = "Course",
            title = "Cursos",
            contentDescription = "Botão Cursos",
            icon = Icons.Default.ArrowForward //Todo -> Alterar icone
        )
    )
}