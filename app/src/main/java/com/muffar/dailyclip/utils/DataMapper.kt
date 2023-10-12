package com.muffar.dailyclip.utils

import com.muffar.dailyclip.data.source.remote.response.MovieItemResponse
import com.muffar.dailyclip.domain.model.Movie

object DataMapper {
    fun mapMovieItemResponseToMovie(value: MovieItemResponse): Movie =
        Movie(
            id = value.id,
            title = value.title,
            poster = value.poster,
            backdrop = value.backdrop,
            rating = value.rating
        )
}