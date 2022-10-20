package br.edu.ifsc.neabiAndroid.ui.course

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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import br.edu.ifsc.neabiAndroid.ui.theme.PrimaryColor
import br.edu.ifsc.neabiAndroid.util.sizeExtraLarge
import br.edu.ifsc.neabiAndroid.util.sizeLarge
import br.edu.ifsc.neabiAndroid.util.sizeMedium

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
                .background(if (isSystemInDarkTheme()) Color.Gray else Color.White)
                .padding(
                    start = sizeLarge,
                    end = sizeLarge,
                    top = sizeExtraLarge,
                    bottom = sizeExtraLarge
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
                modifier = Modifier.fillMaxWidth(),
                factory = { context -> TextView(context) },
                update = { it.text = HtmlCompat.fromHtml(course.value?.course?.description?:"", HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST) }
            )

            val uriHandler = LocalUriHandler.current
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = sizeLarge, end = sizeLarge)
                    .background(color = PrimaryColor, shape = RoundedCornerShape(sizeMedium)),
                shape = RoundedCornerShape(sizeMedium),
                onClick = { uriHandler.openUri(course.value?.link?:"") }
            ) {
                Text("Visitar site do curso")
            }
        }
    }
}
