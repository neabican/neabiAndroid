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
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.navigation.NavController
import br.edu.ifsc.neabiAndroid.domain.model.Course
import br.edu.ifsc.neabiAndroid.ui.sharedcomp.SearchField
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium
import br.edu.ifsc.neabiAndroid.util.sizeSmall

@Composable
fun CourseListScreen(
    navController: NavController,
    viewModel: CourseListViewModel
) {
    val search by viewModel.filter.observeAsState(initial = "")
    val courses by viewModel.courses.observeAsState(initial = listOf())
    val focusManager = LocalFocusManager.current

    Column {
        SearchField(
            search = search,
            onValueChange = {
                viewModel.updateFilter(it)
            },
            focusManager = focusManager,
            onClearButtonClicked = {
                viewModel.updateFilter("")
            }
        )
        LazyColumn(){
            item(){
                Spacer(modifier = Modifier.height(6.dp))
            }
            items(courses.sortedBy { it.name }){
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
            .padding(sizeSmall)
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