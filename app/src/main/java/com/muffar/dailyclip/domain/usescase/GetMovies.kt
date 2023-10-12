package com.muffar.dailyclip.domain.usescase

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository
import com.muffar.dailyclip.utils.ListType
import kotlinx.coroutines.flow.Flow

class GetMovies(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(listType: ListType):Flow<Resource<List<Movie>>> {
        return movieRepository.getMovies(listType)
    }
}