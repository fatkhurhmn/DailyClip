package com.muffar.dailyclip.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.dailyclip.BuildConfig
import com.muffar.dailyclip.R

@Composable
fun PosterImage(
    modifier: Modifier = Modifier,
    url: String,
) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(BuildConfig.BASE_URL_IMAGE + url)
            .placeholder(R.drawable.img_poster_placeholder)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(180.dp)
            .width(120.dp)
            .graphicsLayer(
                clip = true,
                shape = MaterialTheme.shapes.small
            )
    )
}