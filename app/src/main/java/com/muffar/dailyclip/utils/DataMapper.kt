package com.muffar.dailyclip.utils

import com.muffar.dailyclip.data.source.local.MovieEntity
import com.muffar.dailyclip.data.source.remote.response.MovieDetailResponse
import com.muffar.dailyclip.data.source.remote.response.MovieItemResponse
import com.muffar.dailyclip.domain.model.Movie

object DataMapper {
    fun mapMovieItemResponseToMovie(value: MovieItemResponse): Movie =
        Movie(
            id = value.id,
            title = value.title,
            poster = value.poster,
            backdrop = value.backdrop,
            rating = value.rating,
        )

    fun mapMovieDetailResponseToMovie(value: MovieDetailResponse): Movie {
        val genres = value.genres.map { it.name ?: "" }
        return Movie(
            id = value.id,
            title = value.title,
            overview = value.overview,
            rating = value.rating,
            backdrop = value.backdrop,
            runtime = value.runtime,
            genres = genres,
            homepage = value.homepage,
            poster = value.poster,
            releaseDate = value.releaseDate
        )
    }

    fun mapMovieToMovieEntity(value: Movie): MovieEntity {
        val genres = value.genres?.joinToString(",")
        return MovieEntity(
            id = value.id,
            title = value.title,
            genres = genres,
            rating = value.rating,
            poster = value.poster,
            releaseDate = value.releaseDate
        )
    }

    fun mapMovieEntityToMovie(value: MovieEntity): Movie {
        val genres = value.genres?.split(",")
        return Movie(
            id = value.id,
            title = value.title,
            genres = genres,
            rating = value.rating,
            poster = value.poster,
            releaseDate = value.releaseDate
        )
    }
}