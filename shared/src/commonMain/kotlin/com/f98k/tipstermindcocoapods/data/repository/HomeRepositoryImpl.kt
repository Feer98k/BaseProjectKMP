package com.f98k.tipstermindcocoapods.data.repository

import com.f98k.tipstermindcocoapods.data.model.BottomBarItem
import com.f98k.tipstermindcocoapods.data.model.BottomBarList
import com.f98k.tipstermindcocoapods.navigation.TipsterRouters

class HomeRepositoryImpl : HomeRepository {

    override fun getDefaultBottomBar(): BottomBarList {
        return BottomBarList(
            listOf(
                BottomBarItem(
                    iconName = "search",
                    icon = "ic_search",
                    titleEn = "Search",
                    titleEs = "Buscar",
                    titlePt = "Buscar",
                    action = TipsterRouters.SEARCH
                ),
                BottomBarItem(
                    iconName = "aiTips",
                    icon = "ic_brain",
                    titleEn = "AI Tips",
                    titleEs = "AI Tips",
                    titlePt = "AI Tips",
                    action = TipsterRouters.AI_TIPS
                ),
                BottomBarItem(
                    iconName = "home",
                    icon = "ic_home",
                    titleEn = "Home",
                    titleEs = "Home",
                    titlePt = "Home",
                    action = TipsterRouters.HOME

                ),
                BottomBarItem(
                    iconName = "favorites",
                    icon = "ic_star",
                    titleEn = "Favorites",
                    titleEs = "Favoritos",
                    titlePt = "Favoritos",
                    action = TipsterRouters.FAVORITES
                ),
                BottomBarItem(
                    iconName = "settings",
                    icon = "ic_settings",
                    titleEn = "Settings",
                    titleEs = "Ajustes",
                    titlePt = "Configurações",
                    action = TipsterRouters.SETTINGS
                )
            )
        )
    }
}