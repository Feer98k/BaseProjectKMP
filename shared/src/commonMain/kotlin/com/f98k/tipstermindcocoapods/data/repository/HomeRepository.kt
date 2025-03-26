package com.f98k.tipstermindcocoapods.data.repository

import com.f98k.tipstermindcocoapods.data.model.BottomBarList


interface HomeRepository {
    fun getDefaultBottomBar(): BottomBarList
}