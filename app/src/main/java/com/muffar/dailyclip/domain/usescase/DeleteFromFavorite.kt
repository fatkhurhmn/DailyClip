package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository

class DeleteFromFavorite(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(movie: Movie) {
        movieRepository.deleteFromFavorite(movie)
    }
}