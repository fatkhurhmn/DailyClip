package com.muffar.dailyclip.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieVideosResponse(
    val results: List<VideoItemResponse>? = emptyList(),
)

data class VideoItemResponse(
    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("key")
    val key: String? = "",

    @field:SerializedName("type")
    val type: String? = "",
)