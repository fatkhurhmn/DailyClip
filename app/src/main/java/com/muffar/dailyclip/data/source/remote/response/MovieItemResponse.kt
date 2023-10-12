package com.muffar.dailyclip.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieItemResponse(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("poster_path")
    val poster: String? = "",

    @SerializedName("vote_average")
    val rating: Double? = 0.0,
)