package com.muffar.dailyclip.presentation.discover

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.UpdateSearchQuery -> {
                _state.value = _state.value.copy(query = event.searchQuery)
            }

            is SearchEvent.SearchMovies -> {
                searchMovies()
            }
        }
    }

    private fun searchMovies() {
        viewModelScope.launch {
            val movies = movieUseCases.searchMovies(
                query = _state.value.query
            ).cachedIn(viewModelScope)
            _state.value = state.value.copy(movies = movies)
        }
    }
}