package br.edu.ifsc.neabiAndroid.ui.course

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    viewModel: CourseViewModel
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(start = sizeLarge, end = sizeLarge, top = sizeExtraLarge, bottom = sizeExtraLarge),
        verticalArrangement = Arrangement.spacedBy(sizeExtraLarge),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = viewModel.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context -> TextView(context) },
            update = { it.text = HtmlCompat.fromHtml(viewModel.description, HtmlCompat.FROM_HTML_MODE_COMPACT) }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = sizeLarge, end = sizeLarge)
                .background(color = PrimaryColor, shape = RoundedCornerShape(sizeMedium)),
            shape = RoundedCornerShape(sizeMedium),
            onClick = { /*TODO*/ }
        ) {
            Text("Visitar site do curso")
        }
    }
}
