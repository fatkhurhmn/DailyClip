package com.muffar.dailyclip.presentation.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muffar.dailyclip.R
import com.muffar.dailyclip.presentation.favorite.components.FavoriteItem
import com.muffar.dailyclip.ui.common.EmptyListMessage

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigateToDetail: (Int) -> Unit,
) {
    val state = viewModel.state.value

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = stringResource(R.string.menu_favorite),
            style = MaterialTheme.typography.displaySmall.copy(
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, top = 8.dp)
        )

        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            if (!state.movies.isNullOrEmpty()) {
                items(state.movies) {
                    FavoriteItem(
                        movie = it,
                        onClick = { navigateToDetail(it.id ?: 0) }
                    )
                }
            }
        }

        if (state.movies.isNullOrEmpty()) {
            EmptyListMessage(
                modifier = modifier.fillMaxSize(),
                message = stringResource(R.string.no_favorite_movie)
            )
        }
    }
}