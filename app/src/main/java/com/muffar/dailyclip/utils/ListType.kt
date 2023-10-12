package com.muffar.dailyclip.utils

sealed class ListType(val type: String) {
    object NowPlaying : ListType("now_playing")
    object Popular : ListType("popular")
    object TopRated : ListType("topRated")
    object Upcoming : ListType("upcoming")
}