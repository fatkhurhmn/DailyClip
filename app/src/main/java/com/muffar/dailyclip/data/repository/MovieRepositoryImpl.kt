package com.muffar.dailyclip.data.repository

import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.data.source.local.MovieDao
import com.muffar.dailyclip.data.source.remote.MovieApi
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.repository.MovieRepository
import com.muffar.dailyclip.utils.Constants
import com.muffar.dailyclip.utils.DataMapper
import com.muffar.dailyclip.utils.ListType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
) : MovieRepository {
    override suspend fun getMovies(listType: ListType): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading)
        try {
            val response = when (listType) {
                is ListType.NowPlaying -> movieApi.getNowPlayingMovie()
                is ListType.Popular -> movieApi.getPopularMovie()
                is ListType.TopRated -> movieApi.getTopRatedMovie()
                is ListType.Upcoming -> movieApi.getUpcomingMovie()
            }
            val data = response.results?.map {
                DataMapper.mapMovieItemResponseToMovie(it)
            }
            if (!data.isNullOrEmpty()) {
                emit(Resource.Success(data))
            } else {
                emit(Resource.Success(emptyList()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getMovieDetail(id: Int): Flow<Resource<Movie>> = flow {
        emit(Resource.Loading)
        try {
            val response = movieApi.getMovieDetail(id)
            val data = DataMapper.mapMovieDetailResponseToMovie(response)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }

    override suspend fun getMovieVTrailer(id: Int): Flow<Resource<String>> = flow {
        emit(Resource.Loading)
        try {
            val response = movieApi.getMovieVideos(id)
            val data = response.results?.filter { it.type == Constants.TRAILER_KEY }?.get(0)?.key
            emit(Resource.Success(data ?: ""))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
    }

    override suspend fun addToFavorite(movie: Movie) {
        val movieEntity = DataMapper.mapMovieToMovieEntity(movie)
        movieDao.addToFavorite(movieEntity)
    }

    override suspend fun deleteFromFavorite(movie: Movie) {
        val movieEntity = DataMapper.mapMovieToMovieEntity(movie)
        movieDao.deleteFromFavorite(movieEntity)
    }

    override suspend fun getMovieById(id: Int): Movie? {
        val movieEntity = movieDao.getMovieById(id)

        return if (movieEntity == null) {
            null
        } else {
            DataMapper.mapMovieEntityToMovie(movieEntity)
        }
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        val data = movieDao.getFavoriteMovies()
        val movies = data.map {
            it.map { movieEntity -> DataMapper.mapMovieEntityToMovie(movieEntity) }
        }
        return movies
    }
}