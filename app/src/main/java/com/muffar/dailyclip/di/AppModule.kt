package com.muffar.dailyclip.di

import com.muffar.dailyclip.data.repository.MovieRepositoryImpl
import com.muffar.dailyclip.data.source.remote.MovieApi
import com.muffar.dailyclip.domain.repository.MovieRepository
import com.muffar.dailyclip.domain.usescase.GetMovieDetail
import com.muffar.dailyclip.domain.usescase.GetMovies
import com.muffar.dailyclip.domain.usescase.MovieUseCases
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
    ): MovieRepository = MovieRepositoryImpl(movieApi)

    @Provides
    @Singleton
    fun provideMovieUseCases(
        movieRepository: MovieRepository,
    ): MovieUseCases =
        MovieUseCases(
            getMovies = GetMovies(movieRepository),
            getMovieDetail = GetMovieDetail(movieRepository)
        )
}