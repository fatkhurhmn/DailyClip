package com.muffar.dailyclip.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(movie: MovieEntity)

    @Delete
    suspend fun deleteFromFavorite(movie: MovieEntity)

    @Query("SELECT * FROM movie WHERE id = :id ")
    fun getMovieById(id: Int): MovieEntity?

    @Query("SELECT * FROM movie")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
}