package com.muffar.dailyclip.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.home.components.HomeSection
import com.muffar.dailyclip.presentation.home.components.MoviesError
import com.muffar.dailyclip.presentation.home.components.MoviesLoading
import com.muffar.dailyclip.presentation.home.components.NowPlayingMoviesContent
import com.muffar.dailyclip.presentation.home.components.NowPlayingMoviesLoading
import com.muffar.dailyclip.presentation.home.components.PopularMoviesContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val nowPlayingState = viewModel.nowPlayingState.value
    val popularState = viewModel.popularState.value

    Column(modifier = modifier) {
        HomeSection(title = "") {
            if (nowPlayingState.isLoading) {
                NowPlayingMoviesLoading()
            }

            nowPlayingState.nowPlayingMovies?.let {
                NowPlayingMoviesContent(
                    content = it.subList(0, 10),
                    onClick = {},
                )
            }

            if (nowPlayingState.isError) {
                MoviesError(
                    modifier = Modifier.height(200.dp),
                    message = nowPlayingState.errorMessage
                ) {
                    viewModel.getNowPlayingMovies()
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HomeSection(title = stringResource(R.string.popular_movie)) {
            if (popularState.isLoading) {
                MoviesLoading()
            }

            popularState.popularMovies?.let {
                PopularMoviesContent(content = it)
            }

            if (popularState.isError) {
                MoviesError(message = popularState.errorMessage) {
                    viewModel.getPopularMovies()
                }
            }
        }
    }
}