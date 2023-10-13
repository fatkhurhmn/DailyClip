package com.muffar.dailyclip.presentation.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        movieUseCases.getFavoriteMovies().onEach {
            _state.value = state.value.copy(movies = it.asReversed())
        }.launchIn(viewModelScope)
    }
}