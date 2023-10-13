package com.muffar.dailyclip.presentation.discover

import androidx.paging.PagingData
import com.muffar.dailyclip.domain.model.Movie
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val movies: Flow<PagingData<Movie>>? = null,
    val query: String = "",
)
