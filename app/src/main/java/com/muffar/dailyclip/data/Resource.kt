package com.muffar.dailyclip.data

sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    object Empty : Resource<Nothing>()
}