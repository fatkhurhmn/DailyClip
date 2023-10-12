package com.muffar.dailyclip.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muffar.dailyclip.presentation.detail.DetailScreen
import com.muffar.dailyclip.presentation.home.HomeScreen
import com.muffar.dailyclip.utils.Constants

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        route = Constants.MAIN_GRAPH,
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navigateToDetail = { movieId ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Constants.MOVIE_ID_KEY,
                        movieId
                    )
                    navController.navigate(Screen.Detail.route)
                }
            )
        }

        composable(route = Screen.Discover.route) {
            Text(text = "Discover")
        }

        composable(route = Screen.Favorite.route) {
            Text(text = "Favorite")
        }

        composable(Screen.Detail.route) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Int>(Constants.MOVIE_ID_KEY)
                .let { movieId ->
                    DetailScreen(
                        movieId = movieId ?: 0,
                        navigateUp = { navController.popBackStack() }
                    )
                }
        }
    }
}