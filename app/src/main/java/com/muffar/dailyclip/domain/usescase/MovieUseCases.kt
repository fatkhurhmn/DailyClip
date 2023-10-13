package com.muffar.dailyclip.domain.usescase

data class MovieUseCases(
    val getMovies: GetMovies,
    val getMovieDetail: GetMovieDetail,
    val getMovieTrailer: GetMovieTrailer,
    val addToFavorite: AddToFavorite,
    val deleteFromFavorite: DeleteFromFavorite,
    val getMovieById: GetMovieById,
    val getFavoriteMovies: GetFavoriteMovies,
    val searchMovies: SearchMovies
)
