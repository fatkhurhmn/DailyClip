package com.muffar.dailyclip.domain.model

data class Movie(
    val id: Int? = 0,
    val title: String? = "",
    val poster: String? = "",
    val backdrop: String? = "",
    val rating: Double? = 0.0,
    val genres: List<String>? = emptyList(),
    val homepage: String? = "",
    val overview: String? = "",
    val runtime: Int? = 0,
    val releaseDate: String? = "",
)