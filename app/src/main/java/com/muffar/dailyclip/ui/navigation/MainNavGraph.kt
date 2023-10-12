package com.muffar.dailyclip.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muffar.dailyclip.presentation.home.HomeScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        route = "MainGraph",
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        composable(route = Screen.Discover.route) {
            Text(text = "Discover")
        }

        composable(route = Screen.Favorite.route) {
            Text(text = "Favorite")
        }
    }
}