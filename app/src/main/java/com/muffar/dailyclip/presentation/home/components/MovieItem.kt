package com.muffar.dailyclip.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.dailyclip.BuildConfig
import com.muffar.dailyclip.R

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    title: String,
    poster: String,
    rating: Double,
    onClick: () -> Unit,
) {

    val ctx = LocalContext.current

    Card(
        modifier = modifier
            .width(170.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.5.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(ctx)
                        .data(BuildConfig.BASE_URL_API + poster)
                        .placeholder(R.drawable.img_poster_placeholder)
                        .error(R.drawable.img_poster_placeholder)
                        .crossfade(true)
                        .build(),
                    contentDescription = title,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(170.dp)
                        .align(Alignment.CenterHorizontally)
                        .graphicsLayer(
                            clip = true,
                            shape = MaterialTheme.shapes.small
                        )
                )
                Text(
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        lineHeight = 18.sp,
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
            if (rating != 0.0) {
                Text(
                    modifier = Modifier
                        .padding(6.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(2.dp),
                    text = rating.toString().substring(0, 3),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}