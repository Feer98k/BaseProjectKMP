package com.f98k.baseproject.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.f98k.baseproject.data.model.bottombar.BottomBarItem
import com.f98k.baseproject.domain.bridge.VibrationBridge
import com.f98k.baseproject.domain.helper.localizedText
import com.f98k.baseproject.ui.navigation.AppRoute
import com.f98k.baseproject.ui.theme.TipsterTextTypeEnum

@Composable
fun TipsterBottomBar(
    navController: NavHostController,
    items: List<BottomBarItem>,
    isToShowSettingsComponent: (Boolean) -> Unit
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        items.forEach { item ->
            val isSelected = item.action == currentDestination

            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    VibrationBridge.vibrate()
                    if (!isSelected) {
                        if (item.action == AppRoute.Settings.route) {
                            isToShowSettingsComponent(true)
                        } else {
                            isToShowSettingsComponent(false)
                            navController.navigate(item.action) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                },
                icon = {
                    TipsterIcon(
                        item.icon,
                        contentDescription = item.titleEn,
                        modifier = Modifier.size(if (isSelected) 28.dp else 24.dp),
                        tint = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                    )
                },
                label = {
                    TipsterText(
                        text = localizedText(
                            en = item.titleEn,
                            es = item.titleEs,
                            pt = item.titlePt,
                        ),
                        type = TipsterTextTypeEnum.Caption,
                        singleLine = true
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}