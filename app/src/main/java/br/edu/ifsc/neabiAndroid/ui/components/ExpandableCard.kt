package br.edu.ifsc.neabiAndroid.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.edu.ifsc.neabiAndroid.util.sizeExtraLarge
import br.edu.ifsc.neabiAndroid.util.sizeExtraSmall
import br.edu.ifsc.neabiAndroid.util.sizeLarge


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(title: String, cardPadding: Dp = sizeExtraLarge, content: @Composable() () -> Unit) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = cardPadding, end = cardPadding)
            .border(1.dp,Color.Gray, RoundedCornerShape(sizeLarge))
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = {
            expandedState = !expandedState
        },
        shape = RoundedCornerShape(sizeLarge)
    ) {
        Column(
            modifier = Modifier
                .padding(start = sizeExtraLarge, end = sizeExtraLarge, top = sizeExtraSmall, bottom = sizeExtraSmall)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down"
                    )
                }
            }
            if (expandedState) {
                content()
                Spacer(modifier = Modifier.height(sizeLarge))
            }
        }
    }
}
