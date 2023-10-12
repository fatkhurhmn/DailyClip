package com.muffar.dailyclip.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.dailyclip.BuildConfig
import com.muffar.dailyclip.R

@Composable
fun BackdropImage(
    url: String,
) {

    val context = LocalContext.current

    Box {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(BuildConfig.BASE_URL_IMAGE + url)
                .placeholder(R.drawable.img_poster_placeholder)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
        Box(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color.White,
                        ),
                    ),
                )
        )
    }
}