package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetail(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(id: Int): Flow<Resource<Movie>> {
        return movieRepository.getMovieDetail(id)
    }
}