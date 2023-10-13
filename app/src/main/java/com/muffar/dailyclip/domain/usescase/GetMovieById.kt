package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository

class GetMovieById(
    private val movieRepository: MovieRepository,
) {
    operator suspend fun invoke(id: Int): Movie? {
        return movieRepository.getMovieById(id)
    }
}