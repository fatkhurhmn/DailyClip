package com.muffar.dailyclip.data.source.remote

import com.muffar.dailyclip.data.source.remote.response.MovieItemResponse
import com.muffar.dailyclip.data.source.remote.response.WrappedPaginationResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/now_playing")
    fun getNowPlayingMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/popular")
    fun getPopularMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovie(): WrappedPaginationResponse<MovieItemResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovie(): WrappedPaginationResponse<MovieItemResponse>
}