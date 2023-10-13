package com.muffar.dailyclip.presentation.discover.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.muffar.dailyclip.R
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.ui.common.EmptyListMessage

@Composable
fun SearchResultContent(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<Movie>,
    navigateToDetail: (Int) -> Unit,
) {
    if (movies.itemCount == 0) {
        EmptyListMessage(
            modifier = modifier.fillMaxSize(),
            message = stringResource(R.string.no_results_found)
        )
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(movies.itemCount) { index ->
                val movie = movies[index]
                SearchItem(
                    title = movie?.title ?: "",
                    poster = movie?.poster ?: "",
                    rating = movie?.rating ?: 0.0,
                    onClick = { navigateToDetail(movie?.id ?: 0) }
                )
            }
        }
    }
}