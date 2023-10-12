package com.muffar.dailyclip.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    bottomNavigationItem: List<BottomNavigationItem>,
    currentDestination: NavDestination?,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        bottomNavigationItem.map { item ->
            val isSelected = currentDestination?.hierarchy?.any {
                it.route == item.screen.route
            } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if (isSelected) Color.White else Color.DarkGray,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.secondary
                ),
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.DarkGray
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screen,
)