package com.muffar.dailyclip.data.source.remote

import com.muffar.dailyclip.data.source.remote.response.MovieItemResponse
import com.muffar.dailyclip.data.source.remote.response.WrappedPaginationResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/popular")
    suspend fun getPopularMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(): WrappedPaginationResponse<MovieItemResponse>
}