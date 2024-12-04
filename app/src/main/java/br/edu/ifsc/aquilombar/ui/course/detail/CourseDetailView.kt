package br.edu.ifsc.aquilombar.ui.course.detail

import android.widget.TextView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import br.edu.ifsc.aquilombar.ui.theme.PrimaryColor
import br.edu.ifsc.aquilombar.util.sizeExtraLarge
import br.edu.ifsc.aquilombar.util.sizeExtraSmall
import br.edu.ifsc.aquilombar.util.sizeLarge
import br.edu.ifsc.aquilombar.util.sizeMedium

@Composable
fun CourseView(
    viewModel: CoursesViewModel
) {
    val course = viewModel.courses.observeAsState()
    BoxWithConstraints(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .heightIn(min = maxHeight)
                .verticalScroll(rememberScrollState())
                .background(if (isSystemInDarkTheme()) Color.LightGray else Color.White)
                .padding(
                    start = sizeLarge,
                    end = sizeLarge,
                    top = sizeExtraLarge,
                    bottom = sizeExtraSmall
                ),
            verticalArrangement = Arrangement.spacedBy(sizeExtraLarge),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = course.value?.course?.name?:"",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) Color.Black else PrimaryColor
            )

            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                factory = { context -> TextView(context) },
                update = {
                    it.text = HtmlCompat.fromHtml(
                        course.value?.course?.description ?:"",
                        HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST
                    )
                }
            )

            /*if((course.value?.vacancies ?: 0) > 0)
                ExpandableCard(title = "Vagas", cardPadding = 0.dp) {
                    Column {
                        Divider()
                        Text("Vagas totais: ${course.value?.vacancies ?: 0}", fontWeight = FontWeight.Bold)
                        Text("Vagas ampla concorrência: ${course.value?.wideCompetition()}")
                        Text("Vagas escola pública: ${course.value?.publicSchool()}")

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Renda Superior a 1,5 Salários Mínimos", fontWeight = FontWeight.Bold)
                        Divider()
                        Text(text = "Preto | Pardo | Indígena: ${course.value?.RSPPI()}")
                        Text(text = "Não Preto | Pardo | Indígena: ${course.value?.RSNPPI()}")
                        Text(text = "Preto | Pardo | Indígena com deficiência: ${course.value?.RSPPIPCD()}")
                        Text(text = "Não Preto | Pardo | Indígena: ${course.value?.RSNPPIPCD()}")
                        
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Renda Inferior a 1,5 Salários Mínimos", fontWeight = FontWeight.Bold)
                        Divider()
                        Text(text = "Preto | Pardo | Indígena: ${course.value?.RIPPI()}")
                        Text(text = "Não Preto | Pardo | Indígena: ${course.value?.RINPPI()}")
                        Text(text = "Preto | Pardo | Indígena com deficiência: ${course.value?.RIPPIPCD()}")
                        Text(text = "Não Preto | Pardo | Indígena: ${course.value?.RINPPIPCD()}")
                    }
                }*/

            val uriHandler = LocalUriHandler.current
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = sizeLarge, end = sizeLarge, bottom = sizeLarge)
                    .background(color = PrimaryColor, shape = RoundedCornerShape(sizeMedium)),
                shape = RoundedCornerShape(sizeMedium),
                onClick = { uriHandler.openUri(course.value?.link?:"") }
            ) {
                Text("Visitar site do curso")
            }
        }
    }
}
