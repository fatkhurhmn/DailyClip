package com.muffar.dailyclip.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("overview")
    val overview: String? = "",

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("vote_average")
    val rating: Double? = 0.0,

    @SerializedName("backdrop_path")
    val backdrop: String? = "",

    @SerializedName("poster_path")
    val poster: String? = "",

    @SerializedName("runtime")
    val runtime: Int? = 0,

    @SerializedName("genres")
    val genres: List<GenreItemResponse> = emptyList(),

    @SerializedName("homepage")
    val homepage: String? = "",

    @SerializedName("release_date")
    val releaseDate: String? = "",
)