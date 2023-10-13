package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieTrailer(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(id: Int): Flow<Resource<String>> {
        return movieRepository.getMovieVTrailer(id)
    }
}