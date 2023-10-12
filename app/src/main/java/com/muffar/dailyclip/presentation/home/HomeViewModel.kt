package com.muffar.dailyclip.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muffar.dailyclip.data.Resource
import com.muffar.dailyclip.domain.usescase.MovieUseCases
import com.muffar.dailyclip.utils.ListType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {
    private val _nowPlayingState = mutableStateOf(HomeState.NowPlayingMovieState())
    val nowPlayingState: State<HomeState.NowPlayingMovieState> = _nowPlayingState

    private val _popularState = mutableStateOf(HomeState.PopularMovieState())
    val popularState: State<HomeState.PopularMovieState> = _popularState

    private val _topRatedState = mutableStateOf(HomeState.TopRatedMovieState())
    val topRatedState: State<HomeState.TopRatedMovieState> = _topRatedState

    private val _upcomingState = mutableStateOf(HomeState.UpcomingMoviesState())
    val upcomingState: State<HomeState.UpcomingMoviesState> = _upcomingState

    init {
        getNowPlayingMovies()
        getPopularMovies()
        getTopRatedMovies()
        getUpcomingMovies()
    }

    fun getNowPlayingMovies() {
        Log.d("TAG", "getMovies4: ")
        viewModelScope.launch {
            movieUseCases.getMovies(ListType.NowPlaying).onEach { result ->
                when (result) {
                    is Resource.Loading -> _nowPlayingState.value = nowPlayingState.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _nowPlayingState.value = nowPlayingState.value.copy(
                        isLoading = false,
                        isError = false,
                        nowPlayingMovies = result.value
                    )

                    is Resource.Error -> _nowPlayingState.value = nowPlayingState.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }.launchIn(viewModelScope)
        }
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            movieUseCases.getMovies(ListType.Popular).onEach { result ->
                when (result) {
                    is Resource.Loading -> _popularState.value = popularState.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _popularState.value = popularState.value.copy(
                        isLoading = false,
                        isError = false,
                        popularMovies = result.value
                    )

                    is Resource.Error -> _popularState.value = popularState.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            movieUseCases.getMovies(ListType.Popular).onEach { result ->
                when (result) {
                    is Resource.Loading -> _topRatedState.value = topRatedState.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _topRatedState.value = topRatedState.value.copy(
                        isLoading = false,
                        isError = false,
                        topRatedMovies = result.value
                    )

                    is Resource.Error -> _topRatedState.value = topRatedState.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }
        }
    }

    fun getUpcomingMovies() {
        viewModelScope.launch {
            movieUseCases.getMovies(ListType.Popular).onEach { result ->
                when (result) {
                    is Resource.Loading -> _upcomingState.value = upcomingState.value.copy(
                        isLoading = true,
                        isError = false
                    )

                    is Resource.Success -> _upcomingState.value = upcomingState.value.copy(
                        isLoading = false,
                        isError = false,
                        upcomingMovies = result.value
                    )

                    is Resource.Error -> _upcomingState.value = upcomingState.value.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = result.message
                    )

                    else -> {}
                }
            }
        }
    }
}