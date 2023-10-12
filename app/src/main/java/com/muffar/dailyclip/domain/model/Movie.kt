package com.muffar.dailyclip.domain.model

data class Movie(
    val id: Int? = 0,
    val title: String? = "",
    val poster: String? = "",
    val rating: Double? = 0.0,
)