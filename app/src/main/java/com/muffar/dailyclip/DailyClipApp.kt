package com.muffar.dailyclip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.muffar.dailyclip.ui.navigation.AppBottomNavigation
import com.muffar.dailyclip.ui.navigation.BottomNavigationItem
import com.muffar.dailyclip.ui.navigation.MainNavGraph
import com.muffar.dailyclip.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyClipApp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomMenuItems = arrayListOf(
        BottomNavigationItem(
            title = stringResource(R.string.menu_home),
            selectedIcon = Icons.Rounded.Home,
            unselectedIcon = Icons.Outlined.Home,
            screen = Screen.Home
        ),
        BottomNavigationItem(
            title = stringResource(R.string.menu_discover),
            selectedIcon = Icons.Rounded.Search,
            unselectedIcon = Icons.Outlined.Search,
            screen = Screen.Discover
        ),
        BottomNavigationItem(
            title = stringResource(R.string.menu_favorite),
            selectedIcon = Icons.Rounded.Bookmark,
            unselectedIcon = Icons.Outlined.BookmarkBorder,
            screen = Screen.Favorite
        ),
    )

    Scaffold(
        bottomBar = {
            AppBottomNavigation(
                navController = navController,
                bottomNavigationItem = bottomMenuItems,
                currentDestination = currentDestination
            )
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            MainNavGraph(
                navController = navController
            )
        }
    }
}