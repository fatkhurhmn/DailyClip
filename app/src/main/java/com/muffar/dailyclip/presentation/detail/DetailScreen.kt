package com.muffar.dailyclip.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.detail.components.DetailContent
import com.muffar.dailyclip.presentation.detail.components.DetailLoading
import com.muffar.dailyclip.ui.common.RetryLoadData
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    movieId: Int,
    navigateUp: () -> Unit,
    navigateToYoutube: (String) -> Unit,
) {
    val state = viewModel.state.value
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(movieId) {
        viewModel.apply {
            getMovieDetail(movieId)
            getMovieTrailer(movieId)
            getMovieById(movieId)
        }
    }

    LaunchedEffect(true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is DetailViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp),
            verticalArrangement = if (state.isError) Arrangement.Center else Arrangement.Top
        ) {
            if (state.isLoading) {
                DetailLoading()
            }

            if (state.isError) {
                RetryLoadData(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                    errorMessage = state.errorMessage,
                    onRetry = {
                        viewModel.apply {
                            getMovieDetail(movieId)
                            getMovieTrailer(movieId)
                            getMovieById(movieId)
                        }
                    }
                )
            }

            state.movie?.let {
                DetailContent(
                    movie = it,
                    isFavorite = state.isFavorite,
                    onBackPress = navigateUp,
                    onClickSave = {
                        viewModel.onEvent(
                            if (state.isFavorite)
                                DetailEvent.DeleteFromFavorite
                            else
                                DetailEvent.AddToFavorite
                        )
                    },
                    navigateToYoutube = { navigateToYoutube(state.movie.trailer ?: "") },
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.overview),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = state.movie.overview ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}