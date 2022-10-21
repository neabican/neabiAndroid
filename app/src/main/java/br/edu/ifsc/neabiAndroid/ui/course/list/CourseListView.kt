package br.edu.ifsc.neabiAndroid.ui.course.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium
import br.edu.ifsc.neabiAndroid.util.sizeSmall

@Composable
fun CourseListScreen(
    //viewModel: CourseListViewModel
) {

    val searchText by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    Column() {
        TextField(
            value = searchText,
            onValueChange = {

            },
            shape = MaterialTheme.shapes.medium.copy(
                topStart = CornerSize(0.dp),
                topEnd = CornerSize(0.dp)
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Row(){
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    Text("Buscar")
                }
            },
            trailingIcon = {
                if(searchText!=""){
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Limpar Pesquisa")
                    }
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
        LazyColumn(){
            items(listOf<Course>(Course(1,"Análise Desenvolvimento de Sistemas","Sem"))){
                SimpleCardItem(course = it){

                }
            }
        }
    }
}

@Composable
fun SimpleCardItem(
    course: Course,
    onCardClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(sizeMedium)
            .fillMaxWidth()
            .clickable { onCardClicked },
        elevation = sizeSmall,
        shape = RoundedCornerShape(sizeLarge)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(sizeLarge),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(12f)
            ) {
                Text(
                    text = course.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxHeight(),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Acessar curso",
                )
            }
        }
    }
}