package com.muffar.dailyclip.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    val id: Int? = null,
    val title: String? = null,
    val genres: String? = null,
    val poster: String? = null,
    val releaseDate: String? = null,
    val rating: Double? = null,
)