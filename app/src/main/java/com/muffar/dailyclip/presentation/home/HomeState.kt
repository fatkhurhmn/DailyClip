package com.muffar.dailyclip.presentation.home

import com.muffar.dailyclip.domain.model.Movie

sealed class HomeState {
    data class NowPlayingMovieState(
        val nowPlayingMovies: List<Movie>? = null,
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : HomeState()

    data class PopularMovieState(
        val popularMovies: List<Movie>? = null,
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : HomeState()

    data class TopRatedMovieState(
        val topRatedMovies: List<Movie>? = null,
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : HomeState()

    data class UpcomingMoviesState(
        val upcomingMovies: List<Movie>? = null,
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : HomeState()
}