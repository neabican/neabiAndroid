package br.edu.ifsc.neabiAndroid.ui.sharedcomp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchField(
    search: String,
    onValueChange: (String) -> Unit,
    labelName: String = "Buscar",
    focusManager: FocusManager,
    onClearButtonClicked: () -> Unit
) {
    TextField(
        value = search,
        onValueChange = {
            onValueChange(it)
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
                Text(labelName)
            }
        },
        trailingIcon = {
            if(search!=""){
                IconButton(onClick = {  onClearButtonClicked()  }) {
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
}