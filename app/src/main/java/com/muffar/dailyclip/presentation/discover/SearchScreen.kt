package com.muffar.dailyclip.presentation.discover

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.discover.components.SearchLoading
import com.muffar.dailyclip.presentation.discover.components.SearchResultContent
import com.muffar.dailyclip.ui.common.RetryLoadData
import com.muffar.dailyclip.ui.common.SearchBar

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
) {
    val state = viewModel.state.value

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.menu_discover),
            style = MaterialTheme.typography.displaySmall.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp)
        )

        SearchBar(
            text = state.query,
            onValueChange = {
                viewModel.onEvent(SearchEvent.UpdateSearchQuery(it))
            },
            onSearch = {
                viewModel.onEvent(SearchEvent.SearchMovies)
            },
            modifier = modifier.padding(16.dp)
        )

        state.movies?.let {
            val movies = it.collectAsLazyPagingItems()

            when (val moviesState = movies.loadState.refresh) {
                is LoadState.Loading -> SearchLoading()

                is LoadState.Error -> RetryLoadData(
                    modifier = modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                    errorMessage = moviesState.error.message ?: "",
                    onRetry = {
                        viewModel.onEvent(SearchEvent.SearchMovies)
                    }
                )

                else -> SearchResultContent(
                    modifier = modifier,
                    movies = movies,
                    navigateToDetail = { movieId ->
                        navigateToDetail(movieId)
                    },
                )
            }
        }
    }
}