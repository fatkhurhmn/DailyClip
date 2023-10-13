package com.muffar.dailyclip.domain.usescase

import androidx.paging.PagingData
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class SearchMovies(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(query: String): Flow<PagingData<Movie>> {
        return movieRepository.searchMovies(query)
    }
}