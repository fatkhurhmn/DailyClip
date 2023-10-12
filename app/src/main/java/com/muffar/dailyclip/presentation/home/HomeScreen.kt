package com.muffar.dailyclip.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.home.components.HomeSection
import com.muffar.dailyclip.presentation.home.components.NowPlayingError
import com.muffar.dailyclip.presentation.home.components.NowPlayingList
import com.muffar.dailyclip.presentation.home.components.NowPlayingLoading

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val nowPlayingState = viewModel.nowPlayingState.value

    Column(modifier = modifier) {
        HomeSection(title = stringResource(R.string.now_playing)) {
            if (nowPlayingState.isLoading) {
                NowPlayingLoading()
            }

            nowPlayingState.nowPlayingMovies?.let {
                NowPlayingList(
                    content = it.subList(0, 10),
                    onClick = {},
                )
            }

            if (nowPlayingState.isError) {
                NowPlayingError(message = nowPlayingState.errorMessage) {
                    viewModel.getNowPlayingMovies()
                }
            }
        }
    }
}