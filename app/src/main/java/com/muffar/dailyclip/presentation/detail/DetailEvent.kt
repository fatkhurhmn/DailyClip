package com.muffar.dailyclip.presentation.detail

sealed class DetailEvent {
    object AddToFavorite : DetailEvent()
    object DeleteFromFavorite : DetailEvent()
}
