package br.edu.ifsc.neabiAndroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BoxInfo(title: String, quantity: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(title, fontWeight = FontWeight.Bold)
        Text(quantity.toString(), fontWeight = FontWeight.Bold)
    }
}
