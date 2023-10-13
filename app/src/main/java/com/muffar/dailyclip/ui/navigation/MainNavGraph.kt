package com.muffar.dailyclip.ui.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.muffar.dailyclip.presentation.detail.DetailScreen
import com.muffar.dailyclip.presentation.discover.SearchScreen
import com.muffar.dailyclip.presentation.favorite.FavoriteScreen
import com.muffar.dailyclip.presentation.home.HomeScreen
import com.muffar.dailyclip.utils.Constants

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {

    val context = LocalContext.current

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
            SearchScreen(
                navigateToDetail = { movieId ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Constants.MOVIE_ID_KEY,
                        movieId
                    )
                    navController.navigate(Screen.Detail.route)
                }
            )
        }

        composable(route = Screen.Favorite.route) {
            FavoriteScreen(
                navigateToDetail = { movieId ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        Constants.MOVIE_ID_KEY,
                        movieId
                    )
                    navController.navigate(Screen.Detail.route)
                }
            )
        }

        composable(Screen.Detail.route) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Int>(Constants.MOVIE_ID_KEY)
                .let { movieId ->
                    DetailScreen(
                        movieId = movieId ?: 0,
                        navigateUp = { navController.popBackStack() },
                        navigateToYoutube = { key ->
                            val appIntent = Intent(
                                Intent.ACTION_VIEW, Uri.parse(
                                    "vnd.youtube:$key"
                                )
                            )
                            val webIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://www.youtube.com/watch?v=$key")
                            )
                            try {
                                context.startActivity(appIntent)
                            } catch (ex: ActivityNotFoundException) {
                                context.startActivity(webIntent)
                            }
                        }
                    )
                }
        }
    }
}