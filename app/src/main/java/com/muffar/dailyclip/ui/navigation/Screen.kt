package com.muffar.dailyclip.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Discover : Screen("discover")
    object Favorite : Screen("favorite")
    object Detail : Screen("detail")
}