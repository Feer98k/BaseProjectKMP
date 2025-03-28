package com.f98k.tipstermindcocoapods.data.repository.main

import com.f98k.tipstermindcocoapods.data.model.BottomBarList
import com.f98k.tipstermindcocoapods.domain.bridge.readJsonFileFromAssets
import com.f98k.tipstermindcocoapods.domain.extensions.fromJsonOrNull

class MainRepositoryImpl : MainRepository {

    override fun getDefaultBottomBar(): BottomBarList {
        return readJsonFileFromAssets("bottom_bar_items.json").fromJsonOrNull() ?: BottomBarList()
    }
}