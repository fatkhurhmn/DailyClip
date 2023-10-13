package com.muffar.dailyclip.presentation.discover

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()
    object SearchMovies : SearchEvent()
}