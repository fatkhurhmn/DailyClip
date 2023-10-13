package com.muffar.dailyclip.presentation.favorite.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.ui.common.GenreList
import com.muffar.dailyclip.ui.common.PosterImage
import com.muffar.dailyclip.utils.formatIsoDateToCustomFormat

@Composable
fun FavoriteItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp),
    ) {
        Row(
            modifier = modifier
        ) {
            PosterImage(
                url = movie.poster ?: "",
                modifier = Modifier
                    .height(120.dp)
                    .width(80.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = movie.title ?: "",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 20.sp
                    ),
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = movie.releaseDate?.formatIsoDateToCustomFormat() ?: "",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(6.dp))

                GenreList(genres = movie.genres ?: emptyList())

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = movie.rating.toString().substring(0, 3),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFC107)
                    )
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            }
        }
    }
}