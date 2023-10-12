package com.muffar.dailyclip.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class WrappedPaginationResponse<T> (
    @SerializedName("page")
    var page : Int,

    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("total_results")
    var totalResults : Int,

    @SerializedName("results")
    var results : List<T>? = null
)