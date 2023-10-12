package com.muffar.dailyclip.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenreItemResponse(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("name")
    val name: String? = "",
)