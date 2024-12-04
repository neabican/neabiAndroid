package br.edu.ifsc.aquilombar.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Place

object Items {

    val menuItems = listOf(
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