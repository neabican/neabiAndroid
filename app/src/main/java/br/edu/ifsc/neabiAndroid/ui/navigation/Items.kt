package br.edu.ifsc.neabiAndroid.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place

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