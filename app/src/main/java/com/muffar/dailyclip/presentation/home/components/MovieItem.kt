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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muffar.dailyclip.ui.common.PosterImage

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    title: String,
    poster: String,
    rating: Double,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .width(120.dp)
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
                PosterImage(url = poster, modifier = Modifier.height(180.dp))
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