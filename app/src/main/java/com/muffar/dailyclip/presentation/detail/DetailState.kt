package com.muffar.dailyclip.presentation.detail

import com.muffar.dailyclip.domain.model.Movie

data class DetailState(
    val movie: Movie? = null,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val errorMessage: String = "",
)