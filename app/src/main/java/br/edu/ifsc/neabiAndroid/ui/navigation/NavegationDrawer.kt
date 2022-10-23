package br.edu.ifsc.neabiAndroid.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerAppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Sistema Educacional") },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
    )
}

@Composable
fun DrawerHeader(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ){
        Text("Frase/Logo", fontSize = 30.sp)
    }
}

@Composable
fun DrawerBoby(
    items: List<MenuItem>,
    modifier: Modifier,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier){
       items(items){ item ->
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .clickable {
                       onItemClick(item)
                   }
                   .padding(16.dp)
           ) {
               Icon(imageVector = item.icon, contentDescription = item.contentDescription)
               Spacer(modifier = Modifier.width(16.dp))
               Text(
                   text = item.title,
                   style = TextStyle.Default,
                   modifier = Modifier.weight(1f)
               )
           }
       }
    }
}