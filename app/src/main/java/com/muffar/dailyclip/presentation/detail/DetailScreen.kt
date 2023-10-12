package com.muffar.dailyclip.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.detail.components.DetailContent
import com.muffar.dailyclip.presentation.detail.components.DetailLoading
import com.muffar.dailyclip.ui.common.RetryLoadData

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
    movieId: Int,
    navigateUp: () -> Unit,
) {
    val state = viewModel.state.value

    LaunchedEffect(movieId) {
        viewModel.getMovieDetail(movieId)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
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
                onRetry = { viewModel.getMovieDetail(movieId) }
            )
        }

        state.movie?.let {
            DetailContent(
                movie = it,
                onBackPress = navigateUp
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