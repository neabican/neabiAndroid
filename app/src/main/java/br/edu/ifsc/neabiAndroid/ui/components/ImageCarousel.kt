package br.edu.ifsc.neabiAndroid.ui.components


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Carousel(images: List<String>) {
    var index by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(4000L)
            index = (index + 1) % images.size
        }
    }



    AnimatedContent(targetState = index, transitionSpec = {
        slideInHorizontally { height -> height } + fadeIn() with
                slideOutHorizontally { height -> -height } + fadeOut()
    }) { targetCount ->

        val imageUrl = images[index]

        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = "image",
            modifier = Modifier
                .height(340.dp)
                .fillMaxWidth()

        )
    }


}