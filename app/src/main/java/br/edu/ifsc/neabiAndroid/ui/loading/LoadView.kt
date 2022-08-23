package br.edu.ifsc.neabiAndroid.ui.loading

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LoadView(
    loadViewModel: LoadViewModel
){
    val syncState by loadViewModel.currentState.observeAsState()

    Text(
        text = "Sync:"+if (syncState == true) "Done!" else "In progress",
        style = MaterialTheme.typography.h3
            .copy(color = Color.White, fontWeight = FontWeight.Normal)
        ,
        modifier = Modifier.padding(20.dp)
    )
    loadViewModel.syncData()
}