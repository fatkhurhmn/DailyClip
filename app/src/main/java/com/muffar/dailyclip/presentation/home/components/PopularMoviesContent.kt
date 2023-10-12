package com.muffar.dailyclip.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muffar.dailyclip.domain.model.Movie

@Composable
fun PopularMoviesContent(
    modifier: Modifier = Modifier,
    content: List<Movie>,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(content) { movie ->
            MovieItem(
                title = movie.title ?: "",
                poster = movie.poster ?: "",
                rating = String.format("%.1f", movie.rating).toDouble(),
                onClick = {}
            )
        }
    }
}