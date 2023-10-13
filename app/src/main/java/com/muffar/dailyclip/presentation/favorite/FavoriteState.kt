package com.muffar.dailyclip.presentation.favorite

import com.muffar.dailyclip.domain.model.Movie

data class FavoriteState(
    val movies: List<Movie>? = null,
)
