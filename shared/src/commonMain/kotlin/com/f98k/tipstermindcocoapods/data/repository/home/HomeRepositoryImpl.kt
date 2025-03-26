package com.f98k.tipstermindcocoapods.data.repository.home

import com.f98k.tipstermindcocoapods.data.model.BottomBarList
import com.f98k.tipstermindcocoapods.domain.bridge.readJsonFileFromAssets
import com.f98k.tipstermindcocoapods.domain.extensions.fromJsonOrNull

class HomeRepositoryImpl : HomeRepository {

    override fun getDefaultBottomBar(): BottomBarList {
        return readJsonFileFromAssets("bottom_bar_items.json").fromJsonOrNull() ?: BottomBarList()
    }
}