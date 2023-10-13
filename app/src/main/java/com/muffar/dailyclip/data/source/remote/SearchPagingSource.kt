package com.muffar.dailyclip.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.utils.DataMapper

class SearchPagingSource(
    private val movieApi: MovieApi,
    private val query: String,
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: 1
            val response = movieApi.searchMovies(page = page, query = query)
            val data = response.results?.map { DataMapper.mapMovieItemResponseToMovie(it) }?: emptyList()
            LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}