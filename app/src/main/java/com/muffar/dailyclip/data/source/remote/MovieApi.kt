package com.muffar.dailyclip.data.source.remote

import com.muffar.dailyclip.data.source.remote.response.MovieDetailResponse
import com.muffar.dailyclip.data.source.remote.response.MovieItemResponse
import com.muffar.dailyclip.data.source.remote.response.MovieVideosResponse
import com.muffar.dailyclip.data.source.remote.response.WrappedPaginationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/popular")
    suspend fun getPopularMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
    ): MovieDetailResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") id: Int,
    ): MovieVideosResponse
}