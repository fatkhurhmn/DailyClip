package com.muffar.dailyclip.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.model.Movie
import com.muffar.dailyclip.domain.usescase.AddToFavorite
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.AddToFavorite -> addToFavorite(_state.value.movie)
            is DetailEvent.DeleteFromFavorite -> deleteFromFavorite(_state.value.movie)
        }
    }

    fun getMovieById(id: Int) {
        viewModelScope.launch {
            movieUseCases.getMovieById(id)?.let {
                _state.value = state.value.copy(isFavorite = true)
            }
        }
    }

    private fun deleteFromFavorite(movie: Movie?) {
        movie?.let {
            viewModelScope.launch {
                try {
                    movieUseCases.deleteFromFavorite(it)
                    _state.value = state.value.copy(isFavorite = false)
                    _eventFlow.emit(UiEvent.ShowSnackbar("Movie deleted from Favorite"))
                } catch (e: Exception) {
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(e.message ?: "Couldn't delete favorite movie")
                    )
                }
            }
        }
    }

    private fun addToFavorite(movie: Movie?) {
        movie?.let {
            viewModelScope.launch {
                try {
                    movieUseCases.addToFavorite(it)
                    _state.value = state.value.copy(isFavorite = true)
                    _eventFlow.emit(UiEvent.ShowSnackbar("Movie added to Favorite"))
                } catch (e: Exception) {
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(e.message ?: "Couldn't add favorite movie")
                    )
                }
            }
        }
    }

    fun getMovieDetail(id: Int) {
        viewModelScope.launch {
            movieUseCases.getMovieDetail(id).onEach { result ->
                when (result) {
                    is Resource.Loading -> _state.value = state.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _state.value = state.value.copy(
                        isLoading = false,
                        isError = false,
                        movie = result.value
                    )

                    is Resource.Error -> _state.value = state.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }
    }

    fun getMovieTrailer(id: Int) {
        viewModelScope.launch {
            movieUseCases.getMovieTrailer(id).onEach { result ->
                when (result) {
                    is Resource.Loading -> _state.value = state.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            isError = false,
                            movie = state.value.movie?.copy(trailer = result.value)
                        )
                    }

                    is Resource.Error -> _state.value = state.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
    }
}