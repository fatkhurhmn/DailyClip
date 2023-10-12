package com.muffar.dailyclip.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.home.components.HomeSection
import com.muffar.dailyclip.presentation.home.components.MoviesError
import com.muffar.dailyclip.presentation.home.components.MoviesLoading
import com.muffar.dailyclip.presentation.home.components.NowPlayingMoviesContent
import com.muffar.dailyclip.presentation.home.components.NowPlayingMoviesLoading
import com.muffar.dailyclip.presentation.home.components.MoviesContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val nowPlayingState = viewModel.nowPlayingState.value
    val popularState = viewModel.popularState.value
    val topRatedState = viewModel.topRatedState.value
    val upcomingState = viewModel.upcomingState.value

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

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
                MoviesContent(content = it)
            }

            if (popularState.isError) {
                MoviesError(message = popularState.errorMessage) {
                    viewModel.getPopularMovies()
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HomeSection(title = stringResource(R.string.top_rated)) {
            if (topRatedState.isLoading) {
                MoviesLoading()
            }

            topRatedState.topRatedMovies?.let {
                MoviesContent(content = it)
            }

            if (topRatedState.isError) {
                MoviesError(message = topRatedState.errorMessage) {
                    viewModel.getTopRatedMovies()
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HomeSection(title = stringResource(R.string.upcoming)) {
            if (upcomingState.isLoading) {
                MoviesLoading()
            }

            upcomingState.upcomingMovies?.let {
                MoviesContent(content = it)
            }

            if (upcomingState.isError) {
                MoviesError(message = upcomingState.errorMessage) {
                    viewModel.getUpcomingMovies()
                }
            }
        }
    }
}