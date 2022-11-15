package br.edu.ifsc.neabiAndroid.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsc.neabiAndroid.domain.model.Address

@Composable
fun AddressInfo(address: Address?){
    Column(Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(1.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier.weight(5f).padding(start = 20.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Cidade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = address?.city?:"",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
            Column(
                modifier = Modifier.weight(5f).padding(start = 20.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Estado",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = address?.state?:"",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(3.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier.weight(5f).padding(start = 20.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Logradouro",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = address?.public_place?:"",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier.weight(5f).padding(start = 20.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Número",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = address?.number?:"",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
        }
    }
}