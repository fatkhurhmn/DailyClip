package com.muffar.dailyclip.di

import com.muffar.dailyclip.data.repository.MovieRepositoryImpl
import com.muffar.dailyclip.data.source.local.MovieDatabase
import com.muffar.dailyclip.data.source.remote.MovieApi
import com.muffar.dailyclip.domain.repository.MovieRepository
import com.muffar.dailyclip.domain.usescase.AddToFavorite
import com.muffar.dailyclip.domain.usescase.DeleteFromFavorite
import com.muffar.dailyclip.domain.usescase.GetFavoriteMovies
import com.muffar.dailyclip.domain.usescase.GetMovieById
import com.muffar.dailyclip.domain.usescase.GetMovieDetail
import com.muffar.dailyclip.domain.usescase.GetMovieTrailer
import com.muffar.dailyclip.domain.usescase.GetMovies
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import com.muffar.dailyclip.domain.usescase.SearchMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApi: MovieApi,
        movieDatabase: MovieDatabase,
    ): MovieRepository = MovieRepositoryImpl(movieApi, movieDatabase.movieDao)

    @Provides
    @Singleton
    fun provideMovieUseCases(
        movieRepository: MovieRepository,
    ): MovieUseCases =
        MovieUseCases(
            getMovies = GetMovies(movieRepository),
            getMovieDetail = GetMovieDetail(movieRepository),
            getMovieTrailer = GetMovieTrailer(movieRepository),
            addToFavorite = AddToFavorite(movieRepository),
            deleteFromFavorite = DeleteFromFavorite(movieRepository),
            getMovieById = GetMovieById(movieRepository),
            getFavoriteMovies = GetFavoriteMovies(movieRepository),
            searchMovies = SearchMovies(movieRepository)
        )
}