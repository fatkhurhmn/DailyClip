package com.muffar.dailyclip.domain.repository

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.utils.ListType
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(listType: ListType): Flow<Resource<List<Movie>>>
    suspend fun getMovieDetail(id: Int): Flow<Resource<Movie>>
    suspend fun getMovieVTrailer(id: Int): Flow<Resource<String>>
    suspend fun addToFavorite(movie: Movie)
    suspend fun deleteFromFavorite(movie: Movie)
    suspend fun getMovieById(id: Int): Movie?
    fun getFavoriteMovies(): Flow<List<Movie>>
}