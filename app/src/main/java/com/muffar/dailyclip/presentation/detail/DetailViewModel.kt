package com.muffar.dailyclip.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
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
}