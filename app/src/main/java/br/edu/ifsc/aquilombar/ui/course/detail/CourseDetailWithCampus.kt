package br.edu.ifsc.aquilombar.ui.course.detail

import android.widget.TextView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import br.edu.ifsc.aquilombar.ui.course.detail.components.CampusCardSmall
import br.edu.ifsc.aquilombar.ui.theme.PrimaryColor
import br.edu.ifsc.aquilombar.util.sizeExtraLarge
import br.edu.ifsc.aquilombar.util.sizeLarge

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseCampusView(
    viewModel: CourseCampusViewModel,
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            item(span = {
                GridItemSpan(2)
            }) {
                Column() {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(top = sizeLarge, bottom = sizeExtraLarge),
                        text = uiState.course?.name ?: "",
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
                                uiState.course?.description ?:"",
                                HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST
                            )
                        }
                    )
                }
            }

            items(uiState.campus) { campus ->
                CampusCardSmall(
                    navController,
                    campus = campus,
                )
            }
        },
            modifier = Modifier
                .background(if (isSystemInDarkTheme()) Color.LightGray else Color.White)
                .padding(
                    start = sizeLarge,
                    end = sizeLarge,
                ),
        )
}
