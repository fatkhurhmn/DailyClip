package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovies(
    private val movieRepository: MovieRepository,
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovies()
    }
}