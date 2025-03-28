package com.f98k.tipstermindcocoapods.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.topBarFavoriteScreen
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.topIaTipsScreen
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.topSearchScreen
import com.f98k.tipstermindcocoapods.commons.LocalizedStrings.topSettingsScreen
import com.f98k.tipstermindcocoapods.commons.StringConstants.APP_NAME
import com.f98k.tipstermindcocoapods.ui.components.TipsterTopBar
import com.f98k.tipstermindcocoapods.ui.navigation.composable.favorite.FavoritesScreen
import com.f98k.tipstermindcocoapods.ui.navigation.composable.home.HomeScreen
import com.f98k.tipstermindcocoapods.ui.navigation.composable.iaitips.IaTipsScreen
import com.f98k.tipstermindcocoapods.ui.navigation.composable.search.SearchScreen
import com.f98k.tipstermindcocoapods.ui.navigation.composable.settings.SettingsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = AppRoute.Home.route,
    setTopBar: (topBar: @Composable (() -> Unit)?) -> Unit,
    setBottomBarVisibility: (Boolean) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppRoute.Home.route) {
            setTopBar {
                TipsterTopBar(
                    title = APP_NAME,
                    showBackButton = false
                )
            }
            setBottomBarVisibility(true)
            HomeScreen()
        }

        composable(AppRoute.Search.route) {
            setTopBar {
                TipsterTopBar(
                    title = topSearchScreen(),
                    showBackButton = true,
                    onBackClick = { navController.popBackStack() }
                )
            }
            setBottomBarVisibility(true)
            SearchScreen()
        }
        composable(AppRoute.AiTips.route) {
            setTopBar {
                TipsterTopBar(
                    title = topIaTipsScreen(),
                    showBackButton = true,
                    onBackClick = { navController.popBackStack() }
                )
            }
            setBottomBarVisibility(true)
            IaTipsScreen()
        }
        composable(AppRoute.Favorites.route) {
            setTopBar {
                TipsterTopBar(
                    title = topBarFavoriteScreen(),
                    showBackButton = true,
                    onBackClick = { navController.popBackStack() }
                )
            }
            setBottomBarVisibility(true)
            FavoritesScreen()
        }
        composable(AppRoute.Settings.route) {
            setTopBar {
                TipsterTopBar(
                    title = topSettingsScreen(),
                    showBackButton = true,
                    onBackClick = { navController.popBackStack() }
                )
            }
            setBottomBarVisibility(true)
            SettingsScreen()
        }
    }
}
