package com.muffar.dailyclip.domain.repository

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.utils.ListType
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovies(listType: ListType): Flow<Resource<List<Movie>>>
}