package com.f98k.baseproject.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.f98k.baseproject.commons.LocalizedStrings.topBarFavoriteScreen
import com.f98k.baseproject.commons.LocalizedStrings.topIaTipsScreen
import com.f98k.baseproject.commons.LocalizedStrings.topSearchScreen
import com.f98k.baseproject.commons.StringConstants.APP_NAME
import com.f98k.baseproject.ui.components.TipsterTopBar
import com.f98k.baseproject.ui.navigation.composable.favorite.FavoritesScreen
import com.f98k.baseproject.ui.navigation.composable.home.HomeScreen
import com.f98k.baseproject.ui.navigation.composable.iaitips.IaTipsScreen
import com.f98k.baseproject.ui.navigation.composable.search.SearchScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = AppRoute.Home.route,
    setTopBar: (topBar: @Composable (() -> Unit)?) -> Unit,
    setBottomBarVisibility: (Boolean) -> Unit,
    onSettingsClick: () -> Unit = {},
    closeSettingDraw: () -> Unit = {}
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
    }
}
